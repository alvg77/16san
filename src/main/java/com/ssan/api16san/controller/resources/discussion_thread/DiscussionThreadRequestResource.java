package com.ssan.api16san.controller.resources.discussion_thread;

import com.ssan.api16san.controller.resources.PostResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionThreadRequestResource {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime validUntil;
    private String boardName;
}
