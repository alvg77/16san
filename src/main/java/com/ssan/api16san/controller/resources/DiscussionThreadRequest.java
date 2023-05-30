package com.ssan.api16san.controller.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionThreadRequest {
    private Long id;
    private String title;
    private String content;
    private Date validUntil;
    private String boardName;
}
