package com.ssan.api16san.service.impl;

import com.ssan.api16san.repository.UpvoteRepository;
import com.ssan.api16san.service.UpvoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpvoteServiceImpl implements UpvoteService {
    private final UpvoteRepository upvoteRepository;

}
