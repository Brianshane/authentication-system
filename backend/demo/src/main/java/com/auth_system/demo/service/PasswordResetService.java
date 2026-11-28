package com.auth_system.demo.service;

import com.auth_system.demo.entity.PasswordResetToken;
import com.auth_system.demo.entity.User;
import com.auth_system.demo.repository.PasswordResetTokenRepository;
import com.auth_system.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class PasswordResetService {

    private final UserRepository userRepository;
    private final PasswordResetTokenRepository tokenRepository;

    private final SecureRandom secureRandom = new SecureRandom();

    public PasswordResetService(
            UserRepository userRepository,
            PasswordResetTokenRepository tokenRepository) {

        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    private String generateToken() {
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);

        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(randomBytes);
    }

    private String hashToken(String token) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(token.getBytes());

            return Base64.getEncoder()
                    .encodeToString(hashedBytes);

        } catch (Exception exception) {
            throw new IllegalStateException("Could not hash reset token", exception);
        }
    }
}