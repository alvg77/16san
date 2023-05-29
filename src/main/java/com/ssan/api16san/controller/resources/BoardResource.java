package com.ssan.api16san.controller.resources;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class BoardResource {
    private Long id;
    private String name;
    private String description;
    private Long numberOfPosts;
}
