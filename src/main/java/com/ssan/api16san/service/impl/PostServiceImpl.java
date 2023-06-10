package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.DiscussionThread;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.exceptions.UnauthorizedException;
import com.ssan.api16san.exceptions.UserBanException;
import com.ssan.api16san.repository.DiscussionThreadRepository;
import com.ssan.api16san.repository.PostRepository;
import com.ssan.api16san.service.BanService;
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
    private final DiscussionThreadRepository discussionThreadRepository;
    private final BanService banService;
    @Override
    public PostResource save(PostResource postResource, User currentUser) {
        DiscussionThread thread = discussionThreadRepository.findById(postResource.getThreadId()).orElseThrow(
                () -> new EntityNotFoundException("No thread with such id exists!")
        );

        if (banService.isUserBanned(currentUser, thread.getBoard())) {
            throw new UserBanException("User is banned from this board!");
        }

        Post post = MAPPER.fromPostResource(postResource);
        post.setUser(currentUser);
        post.setCreatedAt(new Date());

        return MAPPER.toPostResource(postRepository.save(post));
    }


    @Override
    public PostResource getById(Long id) {
        return MAPPER.toPostResource(
                postRepository.getReferenceById(id)
        );
    }

    @Override
    public void delete(User currentUser, Long id) {
        Post post = postRepository.getReferenceById(id);

        if (
                !moderatorService.userHasModeratorRole(currentUser, post.getDiscussionThread().getBoard()) &&
                (!post.getUser().getId().equals(currentUser.getId()))
        ) {
            throw new IllegalArgumentException("User does not own post");
        }

        postRepository.deleteById(id);
    }

    @Override
    public PostResource update(PostResource postResource, User currentUser, Long id) {
        Post post = postRepository.getReferenceById(id);
        if (post.getUser().getId().equals(currentUser.getId())) {
            throw new UnauthorizedException("Cannot update a post that you do not own!");
        }
        post.setContent(postResource.getContent());
        return MAPPER.toPostResource(postRepository.save(post));
    }

    @Override
    public List<PostResource> getAllPostsFromThread(Long threadId) {
        discussionThreadRepository.getReferenceById(threadId);
        return MAPPER.toPostResourceList(
                postRepository.findByDiscussionThread_Id(threadId)
        );
    }
}
