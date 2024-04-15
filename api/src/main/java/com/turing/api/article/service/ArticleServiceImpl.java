package com.turing.api.article.service;

import com.turing.api.article.model.ArticleDto;
import com.turing.api.article.repository.ArticleRepository;
import com.turing.api.common.component.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

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
    public Optional<ArticleDto> modify(ArticleDto articleDto) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return repository.findAll()
                .stream().map(i->entityToDto(i)).toList();

    }

    @Override
    public Optional<ArticleDto> findById(Long id) {
        return Optional.ofNullable(entityToDto(
                Objects.requireNonNull(repository.findById(id).orElse(null))));
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