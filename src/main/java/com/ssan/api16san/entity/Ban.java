package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class Ban {
    @Id
    @GeneratedValue
    private Long id;

    private LocalTime createdAt;
    private LocalTime expiresAt;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "board")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "moderator")
    private Moderator moderator;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}
