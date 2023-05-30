package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "upvote")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Upvote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (
        name = "id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;
}

