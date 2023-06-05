package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.DiscussionThreadRequest;
import com.ssan.api16san.controller.resources.DiscussionThreadResponse;
import com.ssan.api16san.entity.User;

import java.util.List;

public interface DiscussionThreadService {
    DiscussionThreadResponse save(DiscussionThreadRequest threadRequest, User currentUser);
    List<DiscussionThreadResponse> getAllThreadsByBoardId(Long threadId);
    DiscussionThreadResponse getById(Long id);
    void delete(User currentUser, Long id);
    boolean userIsThreadCreator(Long userId, Long threadId);
    DiscussionThreadResponse update(DiscussionThreadRequest threadRequest, User currentUser, Long id);
}
