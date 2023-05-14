package com.ssan.api16san.entity.report;

import com.ssan.api16san.entity.Board;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "board_report")
@Data
public class BoardReport extends Report {
    @Id
    @GeneratedValue
    @Column(
        name = "board_report_id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
