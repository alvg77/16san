package com.ssan.api16san.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;
    private Date created;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Moderator> moderations;

    @OneToMany(mappedBy = "user")
    private List<Ban> bans;

    @OneToMany(mappedBy = "user")
    private List<Thread> threads;

    @OneToMany(mappedBy = "user")
    private List<Upvote> upvotes;
}
