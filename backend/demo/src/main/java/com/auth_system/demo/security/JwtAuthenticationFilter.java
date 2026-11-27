package com.auth_system.demo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService){
        this.jwtService =jwtService;
    }
    @Override 
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    )
    throws ServletException, IOException{
        String authHeader = request.getHeader("Authorization");
        if(authHeader==null|| !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        String token=authHeader.substring(7);

        try{
            String email = jwtService.extractEmail(token);
            if(SecurityContextHolder.getContext().getAuthentication()==null){
                UsernamePasswordAuthenticationToken authentication= new UsernamePasswordAuthenticationToken(
                    email,
    
                null,
                Collections.emptyList()

                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            }
            catch(JwtException |IllegalArgumentException exception){

                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request,response);

            
        }

    }


