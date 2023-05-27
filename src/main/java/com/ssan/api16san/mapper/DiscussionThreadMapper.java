package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.DiscussionThreadResource;
import com.ssan.api16san.entity.DiscussionThread;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DiscussionThreadMapper {

    @Mapping(target = "boardId", source = "board.id")
    DiscussionThreadResource toDiscussionThreadResource(DiscussionThread discussionThread);

    @Mapping(target = "board.id", source = "boardId")
    DiscussionThread fromDiscussionThreadResource(DiscussionThreadResource discussionThreadResource);
}

