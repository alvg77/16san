package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByDiscussionThread_Id(Long id);
}
