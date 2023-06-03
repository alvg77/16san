package com.ssan.api16san.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity(name="board")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "board",
        uniqueConstraints = {
                @UniqueConstraint(name = "board_name_unique", columnNames = "name"),
        }
)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
            columnDefinition = "DATETIME DEFAULT NOW()"
    )
    private Date createdAt;

    @OneToOne(mappedBy = "board")
    private User creator;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Moderator> moderators;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiscussionThread> threads;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ban> bans;
}
