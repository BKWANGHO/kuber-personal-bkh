package com.turing.api.user.service;

import com.turing.api.common.component.Messenger;
import com.turing.api.common.junit.Item;
import com.turing.api.user.model.UserDto;
import com.turing.api.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserServiceImpleTest {

@Autowired
private UserService service;

    @Test
    @DisplayName("회원수 카운트")
    void count() {
        assertThat(service.count()).isEqualTo(20);
    }

    @Test
    @DisplayName("회원가입")
    void save() {
        UserDto u=UserDto.builder()
                .username("bae")
                .password("1234")
                .name("배광호")
                .job("공인중개사")
                .phone("010-1234-5678")
                .id(100L)
                .build();

        Messenger m = service.save(u);

        assertThat(m.getMessage()).isEqualTo("회원가입 성공");

    }

    @Test
    @DisplayName("회원탈퇴")
    void deleteById() {
        Messenger m = service.deleteById(100L);
        assertThat(m.getMessage()).isEqualTo("회원탈퇴 완료");

    }

    @Test
    @DisplayName("회원목록")
    void findAll() {
        assertThat(service.findAll().size()).isEqualTo(20);
    }

    @Test
    void findById() {


    }
}