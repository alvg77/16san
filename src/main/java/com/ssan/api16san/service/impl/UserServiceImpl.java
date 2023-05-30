package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.UserResource;
import static com.ssan.api16san.mapper.UserMapper.MAPPER;

import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class UserServiceImpl implements UserService {

    private final AuthServiceImpl authService;
    private final UserRepository userRepository;

    @Override
    public UserResource getById(Long id) {
        return MAPPER.toUserResource(
                userRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Cannot find user with the specified id.")
                )
        );
    }

    @Override
    public List<UserResource> getAll() {
        return MAPPER.toUserResourceList(userRepository.findAll());
    }

    @Override
    public UserResource update(UserResource userResource) {
        User current = authService.getCurrentUser();

        current.setUsername(userResource.getUsername());
        current.setEmail(userResource.getEmail());

        return MAPPER.toUserResource(
                userRepository.save(current)
        );
    }

    @Override
    public void delete() {
        userRepository.delete(authService.getCurrentUser());
    }
}
