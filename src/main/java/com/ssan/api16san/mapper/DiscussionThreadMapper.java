package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.discussion_thread.DiscussionThreadRequestResource;
import com.ssan.api16san.entity.DiscussionThread;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DiscussionThreadMapper {

    @Mapping(target = "boardId", source = "board.id")
    DiscussionThreadRequestResource toDiscussionThreadResource(DiscussionThread discussionThread);

    @InheritInverseConfiguration
    DiscussionThread fromDiscussionThreadResource(DiscussionThreadRequestResource discussionThreadRequestResource);
}

