package com.ssan.api16san.controller.resources;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

@Data
public class BanResource {
    private Long id;
    @NonNull
    private Long userId;
    @NonNull
    private Long boardId;
    @NonNull
    private String reason;
    @NonNull
    private LocalDateTime expiresAt;
}
