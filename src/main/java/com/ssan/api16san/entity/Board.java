package com.ssan.api16san.entity;

import com.ssan.api16san.entity.report.BoardReport;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "board")
@Data
@Table(
    name = "board",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "board_name_unique",
            columnNames = "board_name"
        )
    }
)
public class Board {
    @Id
    @GeneratedValue
    @Column(
        name = "board_id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @Column (
        name = "board_name",
        nullable = false,
        columnDefinition = "VARCHAR(20)"
    )
    private String name;

    @Column (
        name = "board_description",
        nullable = false,
        columnDefinition = "Text"
    )
    private String description;


    @OneToMany(mappedBy = "board")
    private List<Moderator> moderators;

    @OneToMany(mappedBy = "board")
    private List<DiscussionThread> discussionThreads;

    @OneToMany(mappedBy = "board")
    private List<Ban> bans;

    @OneToMany(mappedBy = "board")
    private List<BoardReport> reports;
}
