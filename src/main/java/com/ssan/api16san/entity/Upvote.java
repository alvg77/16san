package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "upvote")
@Data
public class Upvote {
    @Id
    @GeneratedValue
    @Column (
        name = "id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}

