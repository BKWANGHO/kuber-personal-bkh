package com.turing.api.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;


    @Override
    public String save(Object o) {
        return null;
    }

    @Override
    public String insertMany() {
        return null;
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public List findAll(){
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id){
        return Optional.empty();
    }

    @Override
    public Board existsById(Long id) {
        return null;
    }
}
