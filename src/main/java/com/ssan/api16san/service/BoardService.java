package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;

public interface BoardService {
    BoardResource save(BoardResource boardResource);
}
