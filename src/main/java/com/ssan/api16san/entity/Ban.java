package com.ssan.api16san.entity;

import com.ssan.api16san.controller.resources.CommunityBoardResource;
import jakarta.persistence.*;
import lombok.Data;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;

    @Column(
        name = "expires_at",
        columnDefinition = "DATETIME"
    )
    private LocalDateTime expiresAt;

    @Column(
        name = "reason",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String reason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "community_board_id")
    private CommunityBoard board;
}
