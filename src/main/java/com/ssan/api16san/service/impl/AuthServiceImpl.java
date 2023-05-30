package com.ssan.api16san.service.impl;

import com.ssan.api16san.config.JWTService;
import com.ssan.api16san.controller.resources.AuthResponseResource;
import com.ssan.api16san.controller.resources.LoginRequestResource;
import com.ssan.api16san.controller.resources.LogoutRequestResource;
import com.ssan.api16san.controller.resources.RegisterRequestResource;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ssan.api16san.mapper.UserMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseResource login(LoginRequestResource request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        String jwtToken = jwtService.generateToken(user);
        AuthResponseResource authResponse =  MAPPER.toAuthResponseResource(userRepository.save(user));
        authResponse.setJwt(jwtToken);

        return authResponse;
    }

    @Override
    public AuthResponseResource register(RegisterRequestResource request) {
        User user = MAPPER.fromRegisterRequestResource(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        String jwtToken = jwtService.generateToken(user);
        AuthResponseResource authResponse =  MAPPER.toAuthResponseResource(userRepository.save(user));
        authResponse.setJwt(jwtToken);

        return authResponse;
    }
}
