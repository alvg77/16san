package com.ssan.api16san.service;

import com.ssan.api16san.entity.User;

public interface UserService {
    User registerNewUser(UserRequestResource user);
    User loginUser(UserRequestResource user);
    boolean validatePassword(String email, String password);
    User updateUser(Long id, UserRequestResource updatedUser);
    void deleteUser(Long id);
    User getUser(Long id);
}
