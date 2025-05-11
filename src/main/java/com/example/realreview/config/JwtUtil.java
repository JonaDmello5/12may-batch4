package com.example.realreview.config;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {
    private final String jwtSecret = "mySecretKey"; // Replace with a secure, long key in production
    private final long jwtExpirationMs = 86400000;  // Token valid for 1 day

    // Used in login where we have the Authentication object
    public String generateToken(Authentication authentication) {
        CustomerUserDetails userDetails = (CustomerUserDetails) authentication.getPrincipal();
        return generateToken(userDetails.getUsername());
    }

    // Used in register() where we only have the username
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                   .setSigningKey(jwtSecret)
                   .parseClaimsJws(token)
                   .getBody()
                   .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException | ExpiredJwtException |
                 UnsupportedJwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(jwtSecret)
                            .parseClaimsJws(token)
                            .getBody();

        return Long.parseLong(claims.getSubject()); // Works only if subject is ID (not username)
    }
}
