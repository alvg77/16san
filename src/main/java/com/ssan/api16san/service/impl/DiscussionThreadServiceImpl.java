package com.ssan.api16san.service.impl;

import com.ssan.api16san.repository.DiscussionThreadRepository;
import com.ssan.api16san.service.DiscussionThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscussionThreadServiceImpl implements DiscussionThreadService {
    private final DiscussionThreadRepository discussionThreadRepository;

}
