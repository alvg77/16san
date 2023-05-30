package com.ssan.api16san.controller;

import com.ssan.api16san.controller.resources.AuthResponseResource;
import com.ssan.api16san.controller.resources.LoginRequestResource;
import com.ssan.api16san.controller.resources.RegisterRequestResource;
import com.ssan.api16san.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseResource> register(
            @RequestBody RegisterRequestResource request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseResource> register(
            @RequestBody LoginRequestResource request
    ) {
        return ResponseEntity.ok(authService.login(request));
    }
}
