package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity(name = "ban")
@Data
public class Ban {
    @Id
    @GeneratedValue
    @Column(
        name = "id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @Column(
        name = "created_at",
        nullable = false,
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalTime createdAt;

    @Column(
        name = "expires_at",
        columnDefinition = "DATETIME"
    )
    private LocalTime expiresAt;

    @Column(
        name = "reason",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String reason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
