package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PostMapper {

    @Mapping(target = "threadId", source = "discussionThread.id")
    PostResource toPostResource(Post post);

    @InheritInverseConfiguration
    Post fromPostResource(PostResource postResource);

    List<PostResource> toPostResourceList(List<Post> postList);
}
