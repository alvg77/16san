package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.DiscussionThreadRequestResource;
import com.ssan.api16san.entity.DiscussionThread;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscussionThreadMapper {
    DiscussionThreadMapper MAPPER = Mappers.getMapper(DiscussionThreadMapper.class);

    @Mapping(target = "boardId", source = "board.id")
    DiscussionThreadRequestResource toDiscussionThreadResource(DiscussionThread discussionThread);

    @InheritInverseConfiguration
    DiscussionThread fromDiscussionThreadResource(DiscussionThreadRequestResource discussionThreadRequestResource);
}

