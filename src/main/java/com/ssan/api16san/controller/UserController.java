package com.ssan.api16san.controller;

import com.ssan.api16san.controller.resources.UserResource;
import com.ssan.api16san.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;

import com.ssan.api16san.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UserResource userResource) {
        return ResponseEntity.ok(userService.update(userResource, authService.getCurrentUser()));
    }

    @DeleteMapping
    public ResponseEntity<?> delete() {
       userService.delete(authService.getCurrentUser().getId());
        return ResponseEntity.noContent().build();
    }
}
