package com.ssan.api16san.controller.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BanResource {
    private Long id;
    private Long username;
    private Long boardName;
    private String reason;
    private Date expiresAt;
}
