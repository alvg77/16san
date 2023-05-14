package com.ssan.api16san.entity;

import com.ssan.api16san.entity.report.PostReport;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "content",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String content;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "discussion_thread_id")
    private DiscussionThread discussionThread;

    @OneToMany(mappedBy = "post")
    private List<Upvote> upvotes;

    @OneToMany(mappedBy = "post")
    private List<PostReport> reports;
}
