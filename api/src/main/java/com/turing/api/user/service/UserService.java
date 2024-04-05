package com.turing.api.user.service;

import com.turing.api.common.service.CommandService;
import com.turing.api.common.service.QueryService;
import com.turing.api.user.model.User;
import com.turing.api.user.model.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {
    //command
    String updatePassword(User user);

    //query
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);

    User findUserByName(String username);



    default User dtoToEntity(UserDto userDto){
        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .phone(userDto.getPhone())
                .job(userDto.getJob())
                .build();
    }

    default UserDto entityToDto(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .phone(user.getPhone())
                .job(user.getJob())
                .build();
    }

}
