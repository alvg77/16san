package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Ban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BanRepository extends JpaRepository<Ban, Long> {
    @Modifying
    @Query("update ban b set b.expiresAt = :expiresAt, b.reason = :reason where b.id = :id")
    Optional<Ban> update(String reason, LocalDateTime expiresAt, Long id);
}
