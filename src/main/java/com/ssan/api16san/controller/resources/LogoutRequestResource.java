package com.ssan.api16san.controller.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// implement after jwt

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoutRequestResource {
    private String email;

}
