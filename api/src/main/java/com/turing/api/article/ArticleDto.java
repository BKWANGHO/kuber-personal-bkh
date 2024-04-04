package com.turing.api.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j
public class ArticleDto {

    private Long id;
    private String title;
    private String content;
    private String registerDate;
    private Long writerId;
    private Long boardId;

}
