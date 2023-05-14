package com.ssan.api16san.entity;

import com.ssan.api16san.entity.report.DiscussionThreadReport;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "discussion_thread")
@Data
public class DiscussionThread {
    @Id
    @GeneratedValue
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "VARCHAR(60)"
    )
    private String title;

    @Column(
            name = "content",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id") // foreign key
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "discussionThread")
    private List<Post> posts;

    @OneToMany(mappedBy = "discussionThread")
    private List<DiscussionThreadReport> reports;
}
