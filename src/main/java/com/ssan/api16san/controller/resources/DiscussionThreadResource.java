package com.ssan.api16san.controller.resources;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
public class DiscussionThreadResource {
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private LocalDateTime validUntil;
    @NonNull
    private Long boardId;
}
