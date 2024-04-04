package com.turing.api.article;

import com.turing.api.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository repository;


    @Override
    public String save(Article article) {
        return null;
    }

    @Override
    public String insertMany() {
        return null;
    }

    @Override
    public String delete(Article article) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return null;
    }

    @Override
    public Optional<ArticleDto> findById(Long id) {
        Article ent = repository.findById(id).get();
        Optional<ArticleDto> dto = entityToDto(ent);

        return Optional.of(dto.orElse(null));
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<ArticleDto> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public Board existsById(Long id) {
        return null;
    }
}
