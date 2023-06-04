package com.ssan.api16san.controller.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResource {
    private Long id;
    private String content;
    private String creatorName;
    private Date createdAt;
    private Long threadId;
    private Integer upvoteCount;
}
