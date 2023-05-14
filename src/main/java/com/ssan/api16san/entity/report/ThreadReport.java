package com.ssan.api16san.entity.report;

import com.ssan.api16san.entity.Thread;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "thread_report")
@Data
public class ThreadReport extends Report {
    @Id
    @GeneratedValue
    @Column(
        name = "thread_report_id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread thread;
}
