package com.ssan.api16san.repository;

import com.ssan.api16san.entity.DiscussionThread;
import com.ssan.api16san.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    @Query("select p from post p where p.discussionThread = ?1")
    Post findByDiscussionThread(DiscussionThread discussionThread);
}
