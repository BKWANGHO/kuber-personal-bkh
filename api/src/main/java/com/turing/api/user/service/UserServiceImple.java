package com.turing.api.user.service;

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

    public void dummy() {

    }

    @Override
    public UserDto save(UserDto userDto) {
        return entityToDto(repository.save(dtoToEntity(userDto)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<UserDto> findAll(PageRequestVo vo) {
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
    public String updatePassword(User user) {
        return null;
    }

    @Override
    public List<?> findUsersByName(String name) {
        return null;
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return null;
    }

    @Override
    public User findUserByName(String username) {
        return null;
    }
}
