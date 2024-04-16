package com.turing.api.common.security.service;

import com.turing.api.common.component.Messenger;
import com.turing.api.user.model.UserDto;

public interface AuthService {
    Messenger login(UserDto param);

    String createToken(UserDto userDto);
}
