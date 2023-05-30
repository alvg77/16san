package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.AuthResponse;
import com.ssan.api16san.controller.resources.RegisterRequest;
import com.ssan.api16san.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User fromRegisterRequestResource(RegisterRequest request);
    AuthResponse toAuthResponseResource(User user);

}
