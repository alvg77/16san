package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.UpvoteResource;
import com.ssan.api16san.entity.User;

public interface UpvoteService {
    void save(UpvoteResource upvoteResource, User currentUser);
    void delete(Long postId, User currentUser);
}
