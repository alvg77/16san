package com.ssan.api16san.entity.report;

import com.ssan.api16san.entity.Post;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "post_report")
@Data
public class PostReport extends Report {
    @Id
    @GeneratedValue
    @Column(
        name = "post_report_id",
        nullable = false,
        updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
