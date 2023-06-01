package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
    Optional<Moderator> findByUser_IdAndBoard_Id(Long uId, Long bId);
}
