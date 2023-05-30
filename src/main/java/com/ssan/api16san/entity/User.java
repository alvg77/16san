package com.ssan.api16san.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="user")
@Data
@RequiredArgsConstructor
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User {
    @Id
    @GeneratedValue
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
            name = "created_at",
            nullable = false,
            columnDefinition = "DATETIME DEFAULT NOW()"
    )
    private Date createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // which field in the Post class maps to this field
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiscussionThread> discussionThreads;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Moderator> moderators;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ban> bans;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Upvote> upvotes;

    @ManyToMany
    @JoinTable(
            name = "user_community_boards",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private List<Board> boards = new ArrayList<>();

}
