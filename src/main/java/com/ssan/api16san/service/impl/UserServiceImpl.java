package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.user.UserRequestResource;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User registerNewUser(UserRequestResource user) {
        return null;
    }

    @Override
    public User loginUser(UserRequestResource user) {
        return null;
    }

    @Override
    public User updateUser(Long id, UserRequestResource updatedUser) {
        return userRepository.updateUsernameAndPasswordById(updatedUser.getUsername(), updatedUser.getPassword(), id);
    }

    @Override
    public void deleteUser(Long id) {
        User toBeDeleted = userRepository.findById(id).orElseThrow();
        userRepository.delete(toBeDeleted);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
