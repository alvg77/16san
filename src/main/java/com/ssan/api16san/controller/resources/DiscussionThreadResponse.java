package com.ssan.api16san.controller.resources;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionThreadResponse {
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String creatorName;
    @NotNull
    private String boardName;
    private Integer postCount;
    private Instant createdAt;
    @NotNull
    private Date validUntil;
}
