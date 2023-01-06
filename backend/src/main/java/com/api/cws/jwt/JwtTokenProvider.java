package com.api.cws.jwt;

import io.jsonwebtoken.*;
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

    public boolean validateToken(String token)
    {
        try
        {
            // key 필요.
            String secretKey = "";
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        }
        catch (ExpiredJwtException e)
        {
            //JWT를 생성할 때 지정한 유효기간 초과할 때.
            log.info("JWT Token 유효기간 초과 => " + e.getMessage());
            return false;
        }
        catch (UnsupportedJwtException e)
        {
            //예상하는 형식과 일치하지 않는 특정 형식이나 구성의 JWT일 때
            log.info("JWT Token 형식 불일치 => " + e.getMessage());
            return false;
        }
        catch (MalformedJwtException e)
        {
            //JWT가 올바르게 구성되지 않았을 때
            log.info("JWT Token 구성 실패 => " + e.getMessage());
            return false;
        }
//        catch (SignatureException e)
//        {
//            //JWT의 기존 서명을 확인하지 못했을 때
//            log.info("JWT Token 서명 확인 실패 => " + e.getMessage());
//            return false;
//        }
        catch (IllegalArgumentException e)
        {
            //IllegalArgumentException
            log.info("IllegalArgumentException => " + e.getMessage());
            return false;
        }
    }
}
