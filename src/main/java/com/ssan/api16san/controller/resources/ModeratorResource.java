package com.ssan.api16san.controller.resources;

import lombok.Data;
import lombok.NonNull;

@Data
public class ModeratorResource {
    private Long id;
    @NonNull
    private Long userId;
    @NonNull
    private Long boardId;
}
