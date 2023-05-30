package com.ssan.api16san.service.impl;

import com.ssan.api16san.entity.Post;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.repository.UpvoteRepository;
import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.UpvoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpvoteServiceImpl implements UpvoteService {
    private final UpvoteRepository upvoteRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void save(Long postId) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postRepository.findById(postId).orElseThrow();
        User user;

        if (principal instanceof User) {
            user = (User) principal;
        } else {
            String username = principal.toString();
            user = userRepository.findByUsername(username).orElseThrow();
        }


    }

}
