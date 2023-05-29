package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.AuthResponseResource;
import com.ssan.api16san.controller.resources.LoginRequestResource;
import com.ssan.api16san.controller.resources.LogoutRequestResource;
import com.ssan.api16san.controller.resources.RegisterRequestResource;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


// ADD PASSWORD ENCRYPTION

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Override
    public AuthResponseResource login(LoginRequestResource loginData) {
        User user = userRepository.findByEmail(loginData.getEmail()).orElseThrow();


        return new AuthResponseResource(user.getUsername(), user.getEmail());
    }

    @Override
    public AuthResponseResource register(RegisterRequestResource registerData) {
        return null;
    }

    @Override
    public AuthResponseResource logout(LogoutRequestResource logoutData) {
        return null;
    }
}
