package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.BoardRepository;
import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.service.BoardService;
import com.ssan.api16san.service.ModeratorService;
import com.ssan.api16san.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.ssan.api16san.mapper.PostMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModeratorService moderatorService;

    @Override
    public PostResource save(PostResource postResource, User currentUser) {
        Post post = MAPPER.fromPostResource(postResource);
        post.setUser(currentUser);
        post.setCreatedAt(new Date());

        return MAPPER.toPostResource(postRepository.save(post));
    }


    @Override
    public PostResource getById(Long id) {
        return MAPPER.toPostResource(
                postRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("No post found with the specified id.")
                )
        );
    }

    @Override
    public void delete(User currentUser, Long id) {
        Post post = postRepository.getReferenceById(id);

        if (
                post != null &&
                !moderatorService.userHasModeratorRole(currentUser.getId(), post.getId()) &&
                (post.getUser().getId() != currentUser.getId())
        ) {
            throw new IllegalArgumentException("User does not own post");
        }

        postRepository.deleteById(id);
    }

    @Override
    public PostResource update(PostResource postResource, User currentUser, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No post found with the specified id."));
        if (post.getUser().getId() == currentUser.getId()) {
            throw new RuntimeException("Cannot update a post that you do not own!");
        }
        post.setContent(postResource.getContent());
        return MAPPER.toPostResource(postRepository.save(post));
    }

    @Override
    public List<PostResource> getAllPostsFromThread(Long threadId) {
        return MAPPER.toPostResourceList(
                postRepository.findAllByThread_Id(threadId)
        );
    }
}
