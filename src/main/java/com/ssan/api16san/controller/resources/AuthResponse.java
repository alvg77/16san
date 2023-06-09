package com.ssan.api16san.controller.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String username;
    private String email;
    private Date createdAt;
    private String jwt;
}
