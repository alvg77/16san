package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "thread")
    private Thread thread;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user")
    private User author;


    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Upvote> upvotes;
}
