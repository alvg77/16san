package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ssan.api16san.entity.DiscussionThread;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionThreadRepository extends JpaRepository<DiscussionThread, Long> {
    @Query("select d from discussion_thread d where d.board = ?1")
    List<DiscussionThread> findByBoard(Board board);
}