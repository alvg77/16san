package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PostMapper {

    @Mapping(target = "threadId", source = "discussionThread.id")
    PostResource toPostResource(Post post);

    @Mapping(target = "discussionThread.id", source = "threadId")
    Post fromPostResource(PostResource postResource);
}
