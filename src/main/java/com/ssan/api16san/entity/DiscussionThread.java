package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "discussion_thread")
@Data
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
            columnDefinition = "DATETIME"
    )
    private String createdAt;

    @Column(
            name = "valid_until",
            columnDefinition = "DATETIME"
    )
    private String validUntil;

    @ManyToOne
    @JoinColumn(name = "user_id") // foreign key
    private User user;

    @OneToMany(mappedBy = "discussionThread")
    private List<Post> posts;

}