package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.DiscussionThreadRequestResource;
import com.ssan.api16san.controller.resources.DiscussionThreadResponseResource;
import com.ssan.api16san.entity.DiscussionThread;
import com.ssan.api16san.mapper.DiscussionThreadMapper;
import com.ssan.api16san.repository.DiscussionThreadRepository;
import com.ssan.api16san.service.DiscussionThreadService;
import static com.ssan.api16san.mapper.DiscussionThreadMapper.MAPPER;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DiscussionThreadServiceImpl implements DiscussionThreadService {
    private final DiscussionThreadRepository discussionThreadRepository;

    public DiscussionThreadResponseResource save(DiscussionThreadRequestResource threadRequestResource) {
        DiscussionThread discussionThread = discussionThreadRepository.save(
                MAPPER.fromDiscussionThreadRequestResource(threadRequestResource)
        );
        return MAPPER.toDiscussionThreadResponseResource(discussionThread);
    }

    public DiscussionThreadResponseResource get(Long id) {
        return MAPPER.toDiscussionThreadResponseResource(
                discussionThreadRepository.findById(id).orElseThrow()
        );
    }

    public List<DiscussionThreadResponseResource> getAll() {
        return MAPPER.toDiscussionThreadResponseResourceList(
                discussionThreadRepository.findAll()
        );
    }

    public void delete(Long id) {
        discussionThreadRepository.deleteById(id);
    }
}
