package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.AuthResponse;
import com.ssan.api16san.controller.resources.LoginRequest;
import com.ssan.api16san.controller.resources.RegisterRequest;
import com.ssan.api16san.entity.User;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);
    AuthResponse register(RegisterRequest registerRequest);

    User getCurrentUser();
}
