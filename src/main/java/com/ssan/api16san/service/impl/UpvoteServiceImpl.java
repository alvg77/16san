package com.ssan.api16san.service.impl;

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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpvoteServiceImpl implements UpvoteService {
    private final UpvoteRepository upvoteRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthServiceImpl authService;

    public void save(Long postId) {
        User user = authService.getCurrentUser();
        Optional<Post> post = Optional.of(postRepository.getReferenceById(postId));

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

    public void delete(Long postId) {
        Optional<Post> post = Optional.of(postRepository.getReferenceById(postId));
        upvoteRepository.deleteByPostAndUser(
            post.orElseThrow(
                () -> new EntityNotFoundException("Cannot find post with the specified id.")
            ),
            authService.getCurrentUser()
        );
    }
}
