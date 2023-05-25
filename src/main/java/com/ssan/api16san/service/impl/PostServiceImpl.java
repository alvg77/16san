package com.ssan.api16san.service.impl;

import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

}
