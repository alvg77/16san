package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.UpvoteResource;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.entity.Upvote;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.repository.UpvoteRepository;
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

    public void save(UpvoteResource upvoteResource, User currentUser) {
        Post post = postRepository.getReferenceById(upvoteResource.getPostId());

        Optional<Upvote> upvoteByPostAndUser = upvoteRepository.findFirstByUserAndPostOrderByIdDesc(
                currentUser, post
        );

        if (upvoteByPostAndUser.isPresent()) {
            throw new EntityExistsException("You have already upvoted this post.");
        }

        Upvote upvote = Upvote
                .builder()
                .user(currentUser)
                .post(post)
                .build();

        upvoteRepository.save(upvote);
    }

    public void delete(Long postId, User currentUser) {
        Optional<Post> post = Optional.of(postRepository.getReferenceById(postId));
        upvoteRepository.deleteByPostAndUser(
            post.orElseThrow(
                () -> new EntityNotFoundException("Cannot find post with the specified id.")
            ),
            currentUser
        );
    }
}
