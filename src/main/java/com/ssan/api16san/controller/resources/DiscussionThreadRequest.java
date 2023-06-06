package com.ssan.api16san.controller.resources;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionThreadRequest {
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    private Date validUntil;
    @NotNull
    private String boardName;
}
