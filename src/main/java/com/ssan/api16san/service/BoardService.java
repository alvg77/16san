package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.User;

import java.util.List;

public interface BoardService {
    BoardResource save(BoardResource boardResource, User currentUser);
    List<BoardResource> getAll();
    BoardResource getById(Long id);
    void delete(User currentUser, Long id);
    BoardResource update(BoardResource boardResource, User currentUser, Long boardId);
}
