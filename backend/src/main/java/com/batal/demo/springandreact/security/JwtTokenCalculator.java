package com.batal.demo.springandreact.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtTokenCalculator {
    private static Logger log = LoggerFactory.getLogger(JwtTokenCalculator.class);

    private String secret;

    public JwtTokenCalculator(String secret) {
        this.secret = secret;
    }

    public Authentication calcAuth(String authorization, String uri) {
        try {
            String token = resolveToken(authorization);
            if (token == null) {
                return null;
            }
            Jws<Claims> claims = getClaims(token);
            log.info("JwtFilter(" + uri + "):begin " + token);
            UserDetails userDetails = new JwtUserDetails(claims.getBody().getSubject());
            return new UsernamePasswordAuthenticationToken(
                    userDetails, "",
                    userDetails.getAuthorities());
        } catch (Exception e) {
            log.warn(e.getMessage());
            return null;
        }
    }

    public String resolveToken(String bearerToken) {
        if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            return null;
        }
        return bearerToken.substring(7);
    }

    private Jws<Claims> getClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }
}
