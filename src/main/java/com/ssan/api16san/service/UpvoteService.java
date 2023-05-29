package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.controller.resources.UpvoteResource;

public interface UpvoteService {
    UpvoteResource save(UpvoteResource upvoteResource);
}
