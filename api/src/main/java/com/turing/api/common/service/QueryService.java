package com.turing.api.common.service;

import com.turing.api.board.model.Board;
import com.turing.api.common.component.PageRequestVo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QueryService<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    long count();
    boolean existsById(Long id);
}
