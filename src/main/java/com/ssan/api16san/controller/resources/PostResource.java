package com.ssan.api16san.controller.resources;

import lombok.Data;
import lombok.NonNull;

@Data
public class PostResource {
    private Long id;
    @NonNull
    private String content;
    @NonNull
    private Long threadId;
}
