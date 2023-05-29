package com.ssan.api16san.controller.resources;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CommunityBoardResource {
    private Long id;
    private String name;
    private String description;
    private Long numberOfPosts;
}
