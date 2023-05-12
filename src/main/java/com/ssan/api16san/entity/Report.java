package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Report {
    @Id
    @GeneratedValue
    private Long id;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "thread")
    private Thread thread;
}
