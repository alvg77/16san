package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.UpvoteResource;
import com.ssan.api16san.entity.Upvote;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpvoteMapper {
    UpvoteMapper MAPPER = Mappers.getMapper(UpvoteMapper.class);

    @Mapping(target = "postId", source = "post.id")
    UpvoteResource toUpvoteResource(Upvote upvote);

    @InheritInverseConfiguration
    Upvote fromUpvoteResource(UpvoteResource upvoteResource);
}
