package com.ssan.api16san.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "discussion_thread")
@Data
@RequiredArgsConstructor
public class DiscussionThread {
    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "VARCHAR(60)"
    )
    private String title;

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
    private Date createdAt;

    @Column(
            name = "valid_until",
            columnDefinition = "DATETIME"
    )
    private Date validUntil;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id") // foreign key
    private User user;

    @OneToMany(mappedBy = "discussionThread", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @ManyToOne(optional = false)
    @JoinColumn(name = "board_id")
    private Board board;
}
