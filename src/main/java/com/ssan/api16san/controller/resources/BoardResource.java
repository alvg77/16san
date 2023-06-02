package com.ssan.api16san.controller.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResource {
    private Long id;
    private String name;
    private String description;
    private Date createdAt;
    private Integer numberOfThreads;
    private Integer numberOfUsers;
}
