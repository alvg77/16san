package com.ssan.api16san.controller.resources;

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
    private String title;
    private String content;
    private String creatorName;
    private String boardName;
    private Integer postCount;
    private Instant createdAt;
    private Date validUntil;
}
