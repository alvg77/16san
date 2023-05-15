package com.ssan.api16san.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name="community_board") // maps this class to an sql table named "User"
@Data
@Table(
        name = "community_board",
        uniqueConstraints = {
                @UniqueConstraint(name = "board_name_unique", columnNames = "board_name"),
        }
)
public class CommunityBoard {
    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "board_name",
            nullable = false,
            columnDefinition = "VARCHAR(45)"
    )
    private String name;

    @Column(
            name = "board_description",
            nullable = false,
            columnDefinition = "Text"
    )
    private String description;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "communityBoards"
    )
    @JsonIgnore
    private List<User> users;
}
