package com.ssan.api16san.controller.resources;

import lombok.Data;
import lombok.NonNull;

@Data
public class CommunityBoardResource {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
}
