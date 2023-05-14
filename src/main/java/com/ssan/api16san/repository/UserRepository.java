package com.ssan.api16san.repository;

import com.ssan.api16san.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
