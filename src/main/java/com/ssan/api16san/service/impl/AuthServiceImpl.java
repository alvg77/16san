package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.AuthResponse;
import com.ssan.api16san.controller.resources.LoginRequest;
import com.ssan.api16san.controller.resources.RegisterRequest;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.AuthService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.ssan.api16san.mapper.AuthMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTServiceImpl jwtServiceImpl;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        User user;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            user = (User) auth.getPrincipal();
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password!");
        }

        String jwtToken = jwtServiceImpl.generateToken(user);
        AuthResponse authResponse = MAPPER.toAuthResponseResource(userRepository.save(user));
        authResponse.setJwt(jwtToken);

        return authResponse;
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        User user = MAPPER.fromRegisterRequestResource(registerRequest);

        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreatedAt(new Date());

        String jwtToken = jwtServiceImpl.generateToken(user);
        AuthResponse authResponse;
        try {
            authResponse = MAPPER.toAuthResponseResource(userRepository.save(user));
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistsException("User with such username/email already exists!");
        }
        authResponse.setJwt(jwtToken);

        return authResponse;
    }

    @Override
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
