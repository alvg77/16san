package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.user.UserRequestResource;
import com.ssan.api16san.controller.resources.user.UserResponseResource;
import com.ssan.api16san.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserRequestResource toUserRequestResource(User user);
    UserResponseResource toUserResponseResource(User user);
    User fromUserRequestResource(UserRequestResource user);
    User fromUserResponseResource(UserResponseResource user);

    List<UserResponseResource> toUserResponseResources(List<User> users);

}
