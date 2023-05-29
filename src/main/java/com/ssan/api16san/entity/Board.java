package com.ssan.api16san.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Entity(name="board")
@Data
@Table(
        name = "board",
        uniqueConstraints = {
                @UniqueConstraint(name = "board_name_unique", columnNames = "name"),
        }
)
public class Board {
    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "VARCHAR(45)"
    )
    private String name;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "VARCHAR(1000)"
    )
    private String description;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private Instant createdAt;

    @OneToMany(mappedBy = "board")
    private List<Moderator> moderators;

    @OneToMany(mappedBy = "board")
    private List<DiscussionThread> threads;

    @OneToMany(mappedBy = "board")
    private List<Ban> bans;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "boards"
    )
    @JsonIgnore
    private List<User> users;
}
