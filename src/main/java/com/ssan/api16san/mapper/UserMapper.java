package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.AuthResponseResource;
import com.ssan.api16san.controller.resources.RegisterRequestResource;
import com.ssan.api16san.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User fromRegisterRequestResource(RegisterRequestResource request);
    AuthResponseResource toAuthResponseResource(User user);
}
