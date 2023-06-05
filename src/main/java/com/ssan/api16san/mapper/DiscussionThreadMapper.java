package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.DiscussionThreadRequest;
import com.ssan.api16san.controller.resources.DiscussionThreadResponse;
import com.ssan.api16san.entity.DiscussionThread;
import com.ssan.api16san.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiscussionThreadMapper {
    DiscussionThreadMapper MAPPER = Mappers.getMapper(DiscussionThreadMapper.class);

    @Mapping(target = "board.name", source = "boardName")
    DiscussionThread fromDiscussionThreadRequestResource(DiscussionThreadRequest discussionThreadRequestResource);

    @Mapping(target = "creatorName", source = "user.username")
    @Mapping(target = "boardName", source = "board.name")
    @Mapping(target = "postCount", expression = "java(getPostCount(discussionThread.getPosts()))")
    DiscussionThreadResponse toDiscussionThreadResponseResource(DiscussionThread discussionThread);

    default Integer getPostCount(List<Post> postList) {
        return postList != null ? postList.size() : 0;
    }

    List<DiscussionThreadResponse> toDiscussionThreadResponseResourceList(List<DiscussionThread> discussionThreadList);

}

