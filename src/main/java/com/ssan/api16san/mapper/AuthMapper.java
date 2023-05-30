package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.AuthResponse;
import com.ssan.api16san.controller.resources.RegisterRequest;
import com.ssan.api16san.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {

    AuthMapper MAPPER = Mappers.getMapper(AuthMapper.class);

    User fromRegisterRequestResource(RegisterRequest request);
    AuthResponse toAuthResponseResource(User user);
}
