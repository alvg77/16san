package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity(name = "moderator")
@Data
@RequiredArgsConstructor
public class Moderator {
    @Id
    @GeneratedValue
    @Column(
        name = "id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "board_id")
    private Board board;

}
