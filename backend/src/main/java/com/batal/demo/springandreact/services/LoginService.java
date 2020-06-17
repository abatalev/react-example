package com.batal.demo.springandreact.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {
    private int duration;
    private String secret;

    @Autowired
    public LoginService(
            @Value("${jwt.duration}") int duration,
            @Value("${jwt.secret}") String secret) {
        this.duration = duration;
        this.secret = secret;
    }

    public String generateToken(String userName) {
        Claims claims = Jwts.claims().setSubject(userName);
        //claims.put("roles", getRoleNames(roles));

        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + duration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
