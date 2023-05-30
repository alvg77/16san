package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.DiscussionThreadRequest;
import com.ssan.api16san.controller.resources.DiscussionThreadResponse;

import java.util.List;

public interface DiscussionThreadService {
    DiscussionThreadResponse save(DiscussionThreadRequest threadRequest);
    List<DiscussionThreadResponse> getAll();
    DiscussionThreadResponse getById(Long id);
    void delete(Long id);
    DiscussionThreadResponse update(DiscussionThreadRequest threadRequest, Long id);
}
