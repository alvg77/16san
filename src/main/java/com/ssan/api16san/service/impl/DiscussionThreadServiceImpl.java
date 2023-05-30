package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.DiscussionThreadRequest;
import com.ssan.api16san.controller.resources.DiscussionThreadResponse;
import com.ssan.api16san.entity.DiscussionThread;
import com.ssan.api16san.repository.DiscussionThreadRepository;
import com.ssan.api16san.service.DiscussionThreadService;
import static com.ssan.api16san.mapper.DiscussionThreadMapper.MAPPER;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscussionThreadServiceImpl implements DiscussionThreadService {
    private final DiscussionThreadRepository discussionThreadRepository;

    @Override
    public DiscussionThreadResponse save(DiscussionThreadRequest threadRequest) {
        DiscussionThread discussionThread = discussionThreadRepository.save(
                MAPPER.fromDiscussionThreadRequestResource(threadRequest)
        );
        return MAPPER.toDiscussionThreadResponseResource(discussionThread);
    }

    @Override
    public DiscussionThreadResponse getById(Long id) {
        return MAPPER.toDiscussionThreadResponseResource(
                discussionThreadRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public List<DiscussionThreadResponse> getAll() {
        return MAPPER.toDiscussionThreadResponseResourceList(
                discussionThreadRepository.findAll()
        );
    }

    @Override
    public void delete(Long id) {
        discussionThreadRepository.deleteById(id);
    }

    @Override
    public DiscussionThreadResponse update(DiscussionThreadRequest threadRequest, Long id) {
        DiscussionThread discussionThread = discussionThreadRepository.getReferenceById(id);
        if (discussionThread == null) {
            throw new EntityNotFoundException("Cannot find discussion thread with the specified id.");
        }

        discussionThread.setTitle(threadRequest.getTitle());
        discussionThread.setContent(threadRequest.getContent());
        discussionThread.setValidUntil(threadRequest.getValidUntil());

        return MAPPER.toDiscussionThreadResponseResource(discussionThreadRepository.save(discussionThread));
    }
}
