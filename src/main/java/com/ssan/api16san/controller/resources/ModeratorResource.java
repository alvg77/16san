package com.ssan.api16san.controller.resources;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeratorResource {
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String boardName;
}
