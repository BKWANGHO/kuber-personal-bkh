package com.turing.api.common.service;

import java.util.Map;

public interface CommandService<T> {
    void dummy();
    T save (T t) ;
    void deleteById (Long id);


}
