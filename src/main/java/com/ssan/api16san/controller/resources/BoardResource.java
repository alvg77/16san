package com.ssan.api16san.controller.resources;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BoardResource {
    private Long id;
    private String name;
    private String description;
    private Integer numberOfThreads;
}
