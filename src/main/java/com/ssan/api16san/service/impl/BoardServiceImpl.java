package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.Moderator;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.exceptions.UnauthorizedException;
import com.ssan.api16san.repository.BoardRepository;
import com.ssan.api16san.repository.ModeratorRepository;
import com.ssan.api16san.service.BoardService;
import com.ssan.api16san.service.ModeratorService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.ssan.api16san.mapper.BoardMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final ModeratorRepository moderatorRepository;
    private final ModeratorService moderatorService;

    @Override
    public BoardResource save(BoardResource boardResource, User currentUser) {
        Board boardEntity = MAPPER.fromBoardResource(boardResource);

        boardEntity.setCreatedAt(new Date());
        boardEntity.setCreator(currentUser);

        try {
            boardEntity = boardRepository.save(boardEntity);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistsException("Board with such name exists already!");
        }

        moderatorRepository.save(
                Moderator
                        .builder()
                        .board(boardEntity)
                        .user(currentUser)
                        .build()
        );

        boardResource.setId(boardEntity.getId());
        boardResource.setCreatedAt(boardEntity.getCreatedAt());
        boardResource.setNumberOfThreads(0);

        return boardResource;
    }

    @Override
    public List<BoardResource> getAll() {
        return MAPPER.toBoardResourceList(boardRepository.findAll());
    }

    @Override
    public BoardResource getById(Long id) {
        return MAPPER.toBoardResource(boardRepository.getReferenceById(id));
    }

    @Override
    public void delete(User currentUser, Long id) {
        Board board = boardRepository.getReferenceById(id);
        if (!board.getCreator().getId().equals(currentUser.getId())) {
            throw new UnauthorizedException("User is not creator of board!");
        }
        boardRepository.deleteById(id);
    }

    @Override
    public BoardResource update(BoardResource boardResource, User currentUser, Long boardId) {
        Board board = boardRepository.getReferenceById(boardId);

        if (!moderatorService.userHasModeratorRole(currentUser, board)) {
            throw new UnauthorizedException("Current user is not moderator of board");
        }

        board.setDescription(boardResource.getDescription());
        board.setName(boardResource.getName());

        return MAPPER.toBoardResource(boardRepository.save(board));
    }
}
