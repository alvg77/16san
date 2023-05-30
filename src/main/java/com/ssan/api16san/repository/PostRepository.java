package com.ssan.api16san.repository;

import com.ssan.api16san.entity.DiscussionThread;
import com.ssan.api16san.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    @Transactional
    @Modifying
    @Query("update post p set p.content = ?1 where p.id = ?2")
    int updateContentById(String content, Long id);
    @Query("select p from post p where p.discussionThread = ?1")
    Post findByDiscussionThread(DiscussionThread discussionThread);
}
