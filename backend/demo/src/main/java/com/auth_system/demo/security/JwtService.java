package com.auth_system.demo.security;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

import javax.crypto.SecretKey;
@Service 
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private  Long expiration;
//genrate signing key
    private SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
//generate token jwt token
    public String generateToken(String email){
        Date now =new Date();
        Date expiryDate = new Date(now.getTime()+expiration);

        return Jwts.builder()
        .subject(email)
        .issuedAt(now)
        .expiration(expiryDate)
        .signWith(getSigningKey())
        .compact();

        
    }
//extract email from tokens
    public String extractEmail(String token){
        return getClaims(token).getSubject();
    }
//extrect token claims
    private Claims getClaims(String token){
        return Jwts.parser()
        .verifyWith(getSigningKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }

    
}
