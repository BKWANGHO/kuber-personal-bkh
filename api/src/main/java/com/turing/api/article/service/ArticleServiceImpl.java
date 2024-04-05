package com.turing.api.article.service;

import com.turing.api.article.model.Article;
import com.turing.api.article.model.ArticleDto;
import com.turing.api.article.repository.ArticleRepository;
import com.turing.api.board.model.Board;
import com.turing.api.common.component.PageRequestVo;
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
    public void dummy() {    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        Long id = articleDto.getWriterId();

        return entityToDto(Optional.of(
                repository.save(dtoToEntity(articleDto))));
    }

    @Override
    public void deleteById(Long id) {
    repository.deleteById(id);
    }

    @Override
    public List<ArticleDto> findAll(PageRequestVo vo) {
//        return repository.findAll(vo);
        return null;
    }

    @Override
    public Optional<ArticleDto> findById(Long id) {
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