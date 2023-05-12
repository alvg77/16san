package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "board")
    private List<Thread> threads;

    @OneToMany(mappedBy = "board")
    private List<Moderator> moderators;

    @OneToMany(mappedBy = "board")
    private List<Ban> bans;

}
