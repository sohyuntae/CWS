package com.api.cws.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    public String createToken(Long userKey, String userId, String userName, String userEmail) {
        Claims claims = Jwts.claims();
        claims.put("userKey", userKey);
        claims.put("userId", userId);
        claims.put("userName", userName);
        claims.put("userEmail", userEmail);

        Date now = new Date();
        Date validity = new Date(now.getTime() + 6000);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                // .signWith()      // key 넣어야함.
                .compact();

        // get 생성
    }
}
