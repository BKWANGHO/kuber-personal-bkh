package com.turing.api.user.service;

import com.turing.api.common.component.JwtProvider;
import com.turing.api.common.component.Messenger;
import com.turing.api.user.model.User;
import com.turing.api.user.model.UserDto;
import com.turing.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService {

    private final UserRepository repository;

    private final JwtProvider jwtProvider;

    @Override
    public Messenger save(UserDto userDto) {

        User user = repository.save(dtoToEntity(userDto));

        return Messenger.builder()
                .message(user instanceof User ? "SUCCESS":"FAIURE")
                .build();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);

//        return Messenger.builder()
//                .message(repository.findById(id).isPresent() ? "SUCCESS" :"FAILURE")
//                .build();

//        return Messenger.builder()
//                .message(repository.existsById(id) ? "SUCCESS" :"FAILURE")
//                .build();

        return Messenger.builder()
                .message(
                        Stream.of(id)
                                .filter(i->existsById(i))
                                .peek(i->repository.deleteById(i))
                                .map(i->"SUCCESS")
                                .findAny()
                                .orElseGet(()->"FAILURE")
                )
                .build();
    }

    @Override
    public Optional<UserDto> modify(UserDto userDto) {
        Optional<User> user = repository.findById(userDto.getId());
        user.get().setName(userDto.getName());
        user.get().setPhone(userDto.getPhone());
        user.get().setJob(userDto.getJob());
        user.get().setUsername(userDto.getUsername());
        return Optional.of(repository.save(user.get())).map(i -> entityToDto(i));
    }


    @Override
    public List<UserDto> findAll() {
        return repository.findAll()
                .stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return Optional.ofNullable(
                entityToDto(Objects.requireNonNull(repository.findById(id).orElse(null))));
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
        return repository.findByName(name);
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {
        return repository.findUsersByJob(job);
    }

    @Override
    public List<UserDto> findUsersByName(String name) {
        return null;
    }

    @Override
    public Optional<UserDto> findUserByUsername(String username) {
        Optional<User> user = repository.findByUsername(username);
        return Optional.of(entityToDto(user.get()));
    }


//  Srp 에 따라 아이디 존재여부를 프론트에서 먼저 판단하고 넘어옴 (시큐리티)
    @Override
    public Messenger login(UserDto param) {
        boolean flag = repository.findByUsername(param.getUsername()).get()
                .getPassword().equals(param.getPassword());

        return Messenger.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .token(flag ? jwtProvider.createToken(param) : "None")
                .build();
    }
}
