package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.UpvoteResource;

public interface UpvoteService {
    void save(UpvoteResource upvoteResource);
    void delete(UpvoteResource upvoteResource);
}
