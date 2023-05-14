package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}