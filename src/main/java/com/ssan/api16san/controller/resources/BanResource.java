package com.ssan.api16san.controller.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BanResource {
    private Long id;
    private String username;
    private String boardName;
    private String reason;
    private Date expiresAt;
}
