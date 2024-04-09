package com.turing.api.article.service;

import com.turing.api.article.model.Article;
import com.turing.api.article.model.ArticleDto;
import com.turing.api.article.repository.ArticleRepository;
import com.turing.api.board.model.Board;
import com.turing.api.board.repository.BoardRepository;
import com.turing.api.common.component.Messenger;
import com.turing.api.common.component.PageRequestVo;
import com.turing.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;
    @Override
    public Messenger save(ArticleDto articleDto) {

//     repository.save(dtoToEntity(articleDto));
        return null;
    }

    @Override
    public Messenger deleteById(Long id) {
    repository.deleteById(id);
    return null;
    }

    @Override
    public Messenger modify(ArticleDto articleDto) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return repository.findAll()
                .stream().map(i->entityToDto(i)).toList();

    }

    @Override
    public Optional<ArticleDto> findById(Long id) {
//        return Optional.of(entityToDto(repository.findById(id)));
        return null;
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