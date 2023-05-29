package com.ssan.api16san.controller.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResource {
    private Long id;
    private String content;
    private String creatorName;
    private Instant createdAt;
    private Long threadId;
}
