package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Upvote {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

}

