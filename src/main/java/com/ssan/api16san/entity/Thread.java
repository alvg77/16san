package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Thread {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String author;

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "thread")
    private List<Post> posts;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

}
