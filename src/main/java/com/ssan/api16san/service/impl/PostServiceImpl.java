package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.service.AuthService;
import com.ssan.api16san.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.ssan.api16san.mapper.PostMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final AuthServiceImpl authService;

    @Override
    public PostResource save(PostResource postResource) {
        Post post = MAPPER.fromPostResource(postResource);
        post.setUser(authService.getCurrentUser());
        return MAPPER.toPostResource(postRepository.save(post));
    }

    @Override
    public List<PostResource> getAll() {
        return MAPPER.toPostResourceList(
                postRepository.findAll()
        );
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
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostResource update(PostResource postResource, Long id) {
        Optional<Post> post = Optional.of(postRepository.getReferenceById(id));
        post.orElseThrow(
                () -> new EntityNotFoundException("No post found with the specified id.")
        ).setContent(postResource.getContent());
        return MAPPER.toPostResource(postRepository.save(post.get()));
    }
}
