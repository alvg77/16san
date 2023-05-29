package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.repository.BoardRepository;
import static com.ssan.api16san.mapper.BoardMapper.MAPPER;
import com.ssan.api16san.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public BoardResource save(BoardResource boardResource) {
        Board boardEntity = boardRepository.save(MAPPER.fromBoardResource(boardResource));
        boardResource.setId(boardEntity.getId());
        return boardResource;
    }

    public List<BoardResource> getAll() {
        return MAPPER.toBoardResourceList(boardRepository.findAll());
    }

    public BoardResource get(Long id) {
        return MAPPER.toBoardResource(boardRepository.findById(id).orElseThrow());
    }

    public BoardResource update(BoardResource boardResource) {
        Board boardEntity = boardRepository.update(boardResource.getName(), boardResource.getDescription(), boardResource.getId()).orElseThrow();
        return MAPPER.toBoardResource(boardEntity);
    }
}
