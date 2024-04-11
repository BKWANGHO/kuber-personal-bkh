package com.turing.api.common.service;

import com.turing.api.common.component.Messenger;

import java.util.Map;
import java.util.Optional;

public interface CommandService<T> {

    Messenger save (T t) ;
    Messenger deleteById (Long id);
    Optional<T> modify (T t);

}
