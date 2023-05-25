package com.ssan.api16san.service.impl;

import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

}
