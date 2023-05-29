package com.ssan.api16san.controller.resources;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class BanResource {
    private Long id;
    private Long username;
    private Long boardName;
    private String reason;
    // format needs to be 2007-12-03T10:15:30
    private LocalDateTime expiresAt;
}
