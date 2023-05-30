package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.repository.BoardRepository;
import com.ssan.api16san.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssan.api16san.mapper.BoardMapper.MAPPER;

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

    @Override
    public List<BoardResource> getAll() {
        return MAPPER.toBoardResourceList(boardRepository.findAll());
    }

    @Override
    public BoardResource get(Long id) {
        return MAPPER.toBoardResource(boardRepository.findById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public void update(BoardResource boardResource) {
        boardRepository.updateNameAndDescriptionById(boardResource.getName(), boardResource.getDescription(), boardResource.getId());
    }
}
