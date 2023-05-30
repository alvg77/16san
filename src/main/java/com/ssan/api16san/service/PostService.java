package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;

import java.util.List;

public interface PostService {
    PostResource save(PostResource postResource);
    List<PostResource> getAll();
    PostResource getById(Long id);
    void delete(Long id);
    PostResource update(PostResource postResource, Long id);
}
