package com.turing.api.article;

import com.turing.api.common.command.CommandService;
import com.turing.api.common.query.QueryService;

import java.sql.SQLException;
import java.util.*;

public interface ArticleService extends CommandService<Article>, QueryService<ArticleDto> {

    default Article dtoToEntity(ArticleDto articleDto){

        Article article = Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .build();

        List<ArticleDto> articleList = new ArrayList<>();
        //board 로 db를 조회해서 해당 게시판에 게시된 글의 목록을 가져올 경우


        return article;
    }

    default Optional<ArticleDto> entityToDto(Article article){
        ArticleDto articleDto = ArticleDto.builder().build();

        return Optional.of(articleDto);
    }

}
