package com.turing.api.board.service;

import com.turing.api.board.model.BoardDto;
import com.turing.api.board.model.BoardDto;
import com.turing.api.board.repository.BoardRepository;
import com.turing.api.board.model.Board;
import com.turing.api.common.component.Messenger;
import com.turing.api.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;


    @Override
    public Messenger save(BoardDto boardDto) {
        entityToDto(Optional.of(repository.save(dtoToEntity(boardDto))));
        return null;

    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return  null;
    }

    @Override
    public Messenger modify(BoardDto boardDto) {
        return null;
    }

    @Override
    public List<BoardDto> findAll() {
//        return repository.findAll(vo);
        return null;
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
        return Optional.of(entityToDto(repository.findById(id)));
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
