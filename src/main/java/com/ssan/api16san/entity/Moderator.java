package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Moderator {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "moderator")
    private List<Ban> bans;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board")
    private Board board;

}
