package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssan.api16san.mapper.PostMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostResource save(PostResource postResource) {
        Post post = postRepository.save(
                MAPPER.fromPostResource(postResource)
        );
        postResource.setId(post.getId());
        return postResource;
    }

    public List<PostResource> getAll() {
        return MAPPER.toPostResourceList(
                postRepository.findAll()
        );
    }

    public PostResource get(Long id) {
        return MAPPER.toPostResource(
                postRepository.findById(id).orElseThrow()
        );
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

}
