package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Transactional
    @Modifying
    @Query("update board b set b.name = ?1, b.description = ?2 where b.id = ?3")
    int updateNameAndDescriptionById(String name, String description, Long id);
}
