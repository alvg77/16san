package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.UserResource;
import com.ssan.api16san.entity.User;

import java.util.List;

public interface UserService {
    UserResource getById(Long id);
    List<UserResource> getAll();
    public UserResource update(UserResource userResource);
    void delete();
}
