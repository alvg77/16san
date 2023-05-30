package com.ssan.api16san.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "moderator")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Moderator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
