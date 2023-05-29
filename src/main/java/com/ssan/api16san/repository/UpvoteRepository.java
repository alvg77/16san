package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Upvote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpvoteRepository extends JpaRepository<Upvote, Long> { }
