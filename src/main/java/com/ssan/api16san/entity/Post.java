package com.ssan.api16san.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity(name = "post")
@Data
@RequiredArgsConstructor
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
            columnDefinition = "DATETIME DEFAULT NOW()"
    )
    private Instant createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "discussion_thread_id")
    private DiscussionThread discussionThread;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Upvote> upvotes;
}
