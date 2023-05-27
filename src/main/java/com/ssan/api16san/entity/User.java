package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="user") // maps this class to an sql table named "User"
@Data
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User {
    @Id // marks this field as the primary key for the table
    @GeneratedValue // tells the database to generate this value
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "VARCHAR(45)"
    )
    private String username;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "VARCHAR(250)"
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "VARCHAR(45)"
    )
    private String password;

    @Column(
            name = "created",
            nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime created;

    @OneToMany(mappedBy = "user") // which field in the Post class maps to this field
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<DiscussionThread> discussionThreads;

    @OneToMany(mappedBy = "user")
    private List<Moderator> moderators;

    @OneToMany(mappedBy = "user")
    private List<Ban> bans;

    @OneToMany(mappedBy = "user")
    private List<Upvote> upvotes;

    @ManyToMany
    @JoinTable(name = "user_community_boards",
            joinColumns = @JoinColumn(name = "user_id"))
    private List<Board> boards = new ArrayList<>();

}
