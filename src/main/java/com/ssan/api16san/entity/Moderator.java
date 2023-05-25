package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "moderator")
@Data
public class Moderator {
    @Id
    @GeneratedValue
    @Column(
        name = "id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
