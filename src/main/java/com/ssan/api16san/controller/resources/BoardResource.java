package com.ssan.api16san.controller.resources;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResource {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private Date createdAt;
    private Integer numberOfThreads;
}
