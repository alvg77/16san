package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
    List<Moderator> findByBoard_Id(Long id);
    Optional<Moderator> findByUser_UsernameAndBoard_Name(String username, String name);
    Optional<Moderator> findByUser_IdAndBoard_Id(Long uId, Long bId);
}
