package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;

public interface PostService {
    Post createPost(PostResource post);
    Post updatePost(Long id, PostResource post);
    Post getPost(Long id);
    void deletePost(Long id);
}
