package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssan.api16san.mapper.PostMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public PostResource save(PostResource postResource) {
        Post post = postRepository.save(
                MAPPER.fromPostResource(postResource)
        );
        return MAPPER.toPostResource(post);
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
                postRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostResource update(PostResource postResource, Long id) {
        Post post = postRepository.getReferenceById(id);
        if (post == null) {
            throw new EntityNotFoundException("Cannot find post with the specified id.");
        }
        post.setContent(postResource.getContent());
        return MAPPER.toPostResource(postRepository.save(post));
    }
}
