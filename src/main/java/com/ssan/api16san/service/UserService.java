package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.user.UserRequestResource;
import com.ssan.api16san.entity.User;

public interface UserService {
    User registerNewUser(UserRequestResource user);
    User loginUser(UserRequestResource user);

    User updateUser(Long id, UserRequestResource updatedUser);
    void deleteUser(Long id);
    User getUser(Long id);


}
