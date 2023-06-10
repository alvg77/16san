package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Ban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BanRepository extends JpaRepository<Ban, Long> {
    List<Ban> findByBoard_Id(Long id);
    Optional<Ban> findByUser_IdAndBoard_Id(Long id, Long id1);
}
