package com.ssan.api16san.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ssan.api16san.entity.DiscussionThread;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiscussionThreadRepository extends JpaRepository<DiscussionThread, Long> {
    List<DiscussionThread> findAllByBoard_Id(Long id);
    Optional<DiscussionThread> findByUser_IdAndId(Long id, Long id1);

    @Override
    Optional<DiscussionThread> findById(Long aLong);
}