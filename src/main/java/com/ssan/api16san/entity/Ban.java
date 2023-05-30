package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "ban")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Date createdAt;

    @Column(
        name = "expires_at",
        columnDefinition = "DATETIME"
    )
    private Date expiresAt;

    @Column(
        name = "reason",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String reason;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "board_id")
    private Board board;
}
