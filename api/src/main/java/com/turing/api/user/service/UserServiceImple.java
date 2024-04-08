package com.turing.api.user.service;

import com.turing.api.common.component.Messenger;
import com.turing.api.common.component.PageRequestVo;
import com.turing.api.user.model.User;
import com.turing.api.user.model.UserDto;
import com.turing.api.user.model.UserDto;
import com.turing.api.user.repository.UserRepository;
import com.turing.api.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService {

    private final UserRepository repository;


    @Override
    public Messenger save(UserDto userDto) {

     repository.save(dtoToEntity(userDto));
        return Messenger.builder()
                .message("회원가입 성공"+userDto.getName())
                .build();
    }

    @Override
    public Messenger deleteById(Long id) {

            repository.deleteById(id);

        return existsById(id) ?
                Messenger.builder()
                .message("회원탈퇴 완료")
                .build() :
                 Messenger.builder()
                .message("회원탈퇴 실패")
                .build();
    }

    @Override
    public Messenger modify(UserDto userDto) {

        return null;
    }


    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return null;
//        return Optional.of(entityToDto(repository.findById(id)));
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<UserDto> findByName(String name) {
        return null;
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {
        return null;
    }

    @Override
    public List<UserDto> findUsersByName(String name) {
        return null;
    }

    @Override
    public Optional<UserDto> findUserByUsername(String username) {
        User user = repository.findByUsername(username);
        return Optional.of(entityToDto(user));
    }



    @Override
    public Messenger login(UserDto param) {
        return null;
    }
}
