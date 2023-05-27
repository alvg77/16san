package com.ssan.api16san.repository;

import com.ssan.api16san.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update user u set u.username = ?1, u.password = ?2 where u.id = ?3")
    User updateUsernameAndPasswordById(String username, String password, Long id);
}
