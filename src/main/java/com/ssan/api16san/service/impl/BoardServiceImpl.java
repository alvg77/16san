package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.Moderator;
import com.ssan.api16san.entity.User;
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
    public BoardResource save(BoardResource boardResource, User currentUser) {
        Board boardEntity = boardRepository.save(MAPPER.fromBoardResource(boardResource));

        moderatorRepository.save(
                new Moderator()
                        .builder()
                        .board(boardEntity)
                        .user(currentUser)
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
    public boolean userHasModeratorRole(User user, Long boardId) {
        return moderatorRepository.findByUser_IdAndBoard_Id(user.getId(), boardId).isEmpty() ? false : true;
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public BoardResource update(BoardResource boardResource, User user, Long boardId) {
        Board board = boardRepository.getReferenceById(boardId);

        if (board == null) {
            throw new EntityNotFoundException("Cannot find a board with the specified id.");
        }

        if (!userHasModeratorRole(user, boardId)) {
            // throw Exception
        }

        board.setDescription(boardResource.getDescription());
        board.setName(boardResource.getName());

        return MAPPER.toBoardResource(boardRepository.save(board));
    }
}
