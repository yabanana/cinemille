package com.example.cinemille.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import com.example.cinemille.model.User;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private final String jwtSecret = "your_secret_key";
    private final long jwtExpirationMs = 3600000; // 1 ora

    public String generateJwtToken(User user) {
        return Jwts.builder()
                .setSubject((user.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            // Token non valido
        }
        return false;
    }
}
