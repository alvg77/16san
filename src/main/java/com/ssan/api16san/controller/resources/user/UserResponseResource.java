package com.ssan.api16san.controller.resources.user;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserResponseResource {
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String email;
}
