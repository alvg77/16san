package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.DiscussionThreadRequestResource;
import com.ssan.api16san.controller.resources.DiscussionThreadResponseResource;

import java.util.List;

public interface DiscussionThreadService {
    DiscussionThreadResponseResource save(DiscussionThreadRequestResource threadRequestResource);
    List<DiscussionThreadResponseResource> getAll();
    DiscussionThreadResponseResource get(Long id);
    void delete(Long id);
}
