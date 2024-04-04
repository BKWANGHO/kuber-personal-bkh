package com.turing.api.common.query;

import com.turing.api.board.Board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface QueryService<T> {
    List<T> findAll() ;
    Optional<T> findById(Long id);
    String count();
    Optional<T> getOne(String id) ;
    Board existsById(Long id);

}
