package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.entity.User;

import java.util.List;

public interface ModeratorService {
    ModeratorResource save(ModeratorResource moderatorResource, User currentUser);
    List<ModeratorResource> getAllModeratorsFromBoard(Long boardId);
    ModeratorResource getById(Long id);
    boolean userHasModeratorRole(Long userId, Long boardId);
    boolean userHasModeratorRole(String username, String boardName);
    void delete(User currentUser, Long id);
}
