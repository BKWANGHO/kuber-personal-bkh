package com.turing.api.article.service;

import com.turing.api.article.model.Article;
import com.turing.api.article.model.ArticleDto;
import com.turing.api.common.service.CommandService;
import com.turing.api.common.service.QueryService;
import com.turing.api.user.model.User;
import com.turing.api.user.model.UserDto;
import com.turing.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {

//    default Article dtoToEntity(ArticleDto articleDto){
    default Article dtoToEntity(ArticleDto articleDto, Long userid){
        UserRepository repo;
        return Article.builder()
//                .title(articleDto.getTitle())
//                .content(articleDto.getContent())
//                .writer(articleDto.getWriter())
//                .writer(userrepo.findById(articleDto.getWriter()))
                .build();
    }

//    default ArticleDto entityToDto(Optional<Article> article, Long userid){
    default ArticleDto entityToDto(Article article){
        return ArticleDto.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .writer(article.getWriter().getUsername())
                .build();
    }

}
