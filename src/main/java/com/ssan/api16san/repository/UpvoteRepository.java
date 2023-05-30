package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Post;
import com.ssan.api16san.entity.Upvote;
import com.ssan.api16san.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UpvoteRepository extends JpaRepository<Upvote, Long> {
    long deleteByPostAndUser(Post post, User user);
    Optional<Upvote> findFirstByUserAndPostOrderByIdDesc(User user, Post post);
}
