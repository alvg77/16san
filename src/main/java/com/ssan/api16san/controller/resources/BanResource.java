package com.ssan.api16san.controller.resources;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BanResource {
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String boardName;
    @NotNull
    private String reason;
    private Date expiresAt;
}
