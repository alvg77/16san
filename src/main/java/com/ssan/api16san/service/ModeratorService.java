package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.controller.resources.ModeratorResource;

import java.util.List;

public interface ModeratorService {
    ModeratorResource save(ModeratorResource moderatorResource);
    List<ModeratorResource> getAll();
    ModeratorResource getById(Long id);
    boolean userHasModeratorRole(Long userId, Long boardId);
    boolean userHasModeratorRole(String username, String boardName);
    void delete(Long id);
}
