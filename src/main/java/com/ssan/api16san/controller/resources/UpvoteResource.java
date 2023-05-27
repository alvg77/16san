package com.ssan.api16san.controller.resources;

import lombok.Data;
import lombok.NonNull;

@Data
public class UpvoteResource {
    private Long id;
    @NonNull
    private Long postId;
}
