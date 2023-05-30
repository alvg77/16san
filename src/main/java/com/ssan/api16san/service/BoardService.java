package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;

import java.util.List;

public interface BoardService {
    BoardResource save(BoardResource boardResource);
    List<BoardResource> getAll();
    BoardResource get(Long id);
    void delete(Long id);
    void update(BoardResource boardResource);
}
