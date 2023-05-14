package com.ssan.api16san.entity.report;

import com.ssan.api16san.entity.DiscussionThread;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "thread_report")
@Data
public class DiscussionThreadReport extends Report {
    @Id
    @GeneratedValue
    @Column(
        name = "thread_report_id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discussion_thread_id")
    private DiscussionThread discussionThread;
}
