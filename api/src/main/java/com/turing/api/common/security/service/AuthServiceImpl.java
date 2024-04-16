package com.turing.api.common.security.service;

import com.turing.api.common.component.Messenger;
import com.turing.api.user.model.UserDto;
import com.turing.api.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;


    @Override
    public Messenger login(UserDto param) {

        boolean flag = repository.findByUsername(param.getUsername()).get()
                .getPassword().equals(param.getPassword());


        return Messenger.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .token(flag ? createToken(param) : "None")
                .build();
    }

    @Override
    public String createToken(UserDto userDto) {
//        Claims claims = (Claims) Jwts.claims();
//        claims.put("username", userDto.getUsername());
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime tokenValidTime = now.plusSeconds(24 * 60 * 60 * 1000);
//
//
        return null;
    }


}
