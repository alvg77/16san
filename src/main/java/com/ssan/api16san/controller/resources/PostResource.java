package com.ssan.api16san.controller.resources;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResource {
    private Long id;
    @NotNull
    private String content;
    private String creatorName;
    private Date createdAt;
    @NotNull
    private Long threadId;
    private Integer upvoteCount;
}
