package com.auth_system.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth_system.demo.entity.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository <PasswordResetToken ,Long> {

    Optional<PasswordResetToken>  findByTokenHash(String tokenHash);
     void deleteByUserId(Long userId);
}
