package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.entity.User;

import java.util.List;

public interface PostService {
    PostResource save(PostResource postResource, User currentUser);
    PostResource getById(Long id);
    void delete(User currentUser, Long id);
    PostResource update(PostResource postResource, User currentUser, Long id);
    List<PostResource> getAllPostsFromThread(Long threadId);
}
