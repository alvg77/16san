package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ssan.api16san.entity.DiscussionThread;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiscussionThreadRepository extends JpaRepository<DiscussionThread, Long> {
    @Transactional
    @Modifying
    @Query("update discussion_thread d set d.title = ?1, d.content = ?2, d.validUntil = ?3 where d.id = ?4")
    int updateTitleAndContentAndValidUntilById(String title, String content, Date validUntil, Long id);
}