package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.Moderator;
import com.ssan.api16san.repository.BoardRepository;
import com.ssan.api16san.repository.ModeratorRepository;
import com.ssan.api16san.service.BoardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssan.api16san.mapper.BoardMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final AuthServiceImpl authService;
    private final ModeratorRepository moderatorRepository;

    @Override
    public BoardResource save(BoardResource boardResource) {
        Board boardEntity = boardRepository.save(MAPPER.fromBoardResource(boardResource));

        moderatorRepository.save(
                new Moderator()
                .builder()
                .board(boardEntity)
                .user(authService.getCurrentUser())
                .build()
        );

        boardResource.setId(boardEntity.getId());
        return boardResource;
    }

    @Override
    public List<BoardResource> getAll() {
        return MAPPER.toBoardResourceList(boardRepository.findAll());
    }

    @Override
    public BoardResource getById(Long id) {
        return MAPPER.toBoardResource(boardRepository.findById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public BoardResource update(BoardResource boardResource, Long id) {
        Board board = boardRepository.getReferenceById(id);

        if (board == null) {
            throw new EntityNotFoundException("Cannot find a board with the specified id.");
        }

        board.setDescription(boardResource.getDescription());
        board.setName(boardResource.getName());

        return MAPPER.toBoardResource(boardRepository.save(board));
    }
}
