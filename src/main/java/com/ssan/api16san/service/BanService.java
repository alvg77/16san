package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.entity.Ban;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.User;

import java.util.List;

public interface BanService {
    BanResource save(BanResource banResource, User currentUser);
    boolean isUserBanned(User user, Board board);
    BanResource getById(Long id);
    void delete(User currentUser, Long id);
    BanResource update(BanResource banResource, User currentUser, Long id);
    List<BanResource> getAllBansFromBoard(long boardId);
}
