package com.microsevriceslesson.plateService.security;

import com.microsevriceslesson.plateService.config.AppProperties;
import com.microsevriceslesson.plateService.security.oauth2.user.LocalUser;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenProvider {

    private final AppProperties appProperties;

    public String createToken(Authentication authentication) {
        LocalUser userPrincipal = (LocalUser) authentication.getPrincipal();

        LocalDate now = LocalDate.now();
        LocalDate expiryDate = now.plusDays(1);

        return Jwts
                .builder()
                .setSubject(Long.toString(userPrincipal.getUser().getUserId()))
                .setIssuedAt(Date.valueOf(now))
                .setExpiration(Date.valueOf(expiryDate))
                .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret()).compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}