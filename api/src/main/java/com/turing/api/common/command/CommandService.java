package com.turing.api.common.command;

import java.util.Map;

public interface CommandService<T> {
    String save (T t) ;
    String insertMany();
    String delete (T t);


}
