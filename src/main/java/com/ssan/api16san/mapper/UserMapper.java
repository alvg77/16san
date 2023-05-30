package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.UserResource;
import com.ssan.api16san.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User fromUserResource(UserResource userResource);
    UserResource toUserResource(User user);

    List<UserResource> toUserResourceList(List<User> userList);
}
