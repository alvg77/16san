package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.UpvoteResource;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.entity.Upvote;
import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.repository.UpvoteRepository;
import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.UpvoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssan.api16san.mapper.UpvoteMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class UpvoteServiceImpl implements UpvoteService {
    private final UpvoteRepository upvoteRepository;
    private final PostRepository postRepository;

    public UpvoteResource save(UpvoteResource upvoteResource) {
        Post post = postRepository.findById(upvoteResource.getPostId()).orElseThrow();

        return null;
    }

}
