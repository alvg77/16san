package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.User;

import java.util.List;

public interface BoardService {
    BoardResource save(BoardResource boardResource, User currentUser);
    List<BoardResource> getAll();
    BoardResource getById(Long id);
    boolean userHasModeratorRole(User user, Long boardId);
    void delete(Long id);
    BoardResource update(BoardResource boardResource, User user, Long boardId);
}
