package com.turing.api.common.component;


import com.turing.api.user.model.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Security;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
public class JwtProvider {

    @Value("${jwt.iss}")
    private String issuer;

    private final SecretKey secretkey;

    Instant expiredDate = Instant.now().plus(1, ChronoUnit.DAYS);

    public JwtProvider (@Value("${jwt.secret}") String secretKey){
        this.secretkey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
    }

    public String createToken(UserDto userDto) {
        String toke = Jwts.builder()
                .issuer(issuer)
                .signWith(secretkey)
                .expiration(Date.from(expiredDate))
                .subject("turing")
                .claim("username", userDto.getUsername())
                .claim("job", userDto.getJob())
                .claim("userId", userDto.getId())
                .compact();

        log.info("로그인성공으로 발급된 토큰 " + toke);
        return toke;
    }


}
