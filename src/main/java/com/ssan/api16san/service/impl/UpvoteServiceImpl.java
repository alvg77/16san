package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.UpvoteResource;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.entity.Upvote;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.repository.UpvoteRepository;
import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.UpvoteService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpvoteServiceImpl implements UpvoteService {
    private final UpvoteRepository upvoteRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthServiceImpl authService;

    public void save(UpvoteResource upvoteResource) {
        User user = authService.getCurrentUser();
        Optional<Post> post = Optional.of(postRepository.getReferenceById(upvoteResource.getPostId()));

        if (post.isEmpty()) {
            throw new EntityNotFoundException("Cannot find post with the specified id.");
        }

        Optional<Upvote> upvoteByPostAndUser = upvoteRepository.findFirstByUserAndPostOrderByIdDesc(
                user, post.get()
        );

        if (upvoteByPostAndUser.isPresent()) {
            throw new EntityExistsException("You have already upvoted this post.");
        }

        Upvote upvote = Upvote
                .builder()
                .user(user)
                .post(post.get())
                .build();

        upvoteRepository.save(upvote);
    }

    public void delete(UpvoteResource upvoteResource) {
        Optional<Post> post = Optional.of(postRepository.getReferenceById(upvoteResource.getPostId()));
        upvoteRepository.deleteByPostAndUser(
            post.orElseThrow(
                () -> new EntityNotFoundException("Cannot find post with the specified id.")
            ),
            authService.getCurrentUser()
        );
    }
}
