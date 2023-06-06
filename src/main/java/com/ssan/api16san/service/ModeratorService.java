package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.User;

import java.util.List;

public interface ModeratorService {
    ModeratorResource save(ModeratorResource moderatorResource, User currentUser);
    List<ModeratorResource> getAllModeratorsFromBoard(Long boardId);
    ModeratorResource getById(Long id);
    boolean userHasModeratorRole(User user, Board board);
    void delete(User currentUser, Long id);
}
