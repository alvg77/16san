package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.entity.Post;
import com.ssan.api16san.entity.Upvote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {

    PostMapper MAPPER = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "threadId", source = "discussionThread.id")
    @Mapping(target = "creatorName", source = "user.username")
    @Mapping(target = "upvoteCount", expression = "java(getUpvoteCount(post.getUpvotes()))")
    PostResource toPostResource(Post post);

    @Mapping(target = "discussionThread.id", source = "threadId")
    Post fromPostResource(PostResource postResource);

    default Integer getUpvoteCount(List<Upvote> upvoteList) {
        return upvoteList.size();
    }

    List<PostResource> toPostResourceList(List<Post> postList);
}
