package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.AuthResponseResource;
import com.ssan.api16san.controller.resources.LoginRequestResource;
import com.ssan.api16san.controller.resources.LogoutRequestResource;
import com.ssan.api16san.controller.resources.RegisterRequestResource;

public interface AuthService {
    AuthResponseResource login(LoginRequestResource loginData);
    AuthResponseResource register(RegisterRequestResource registerData);
}
