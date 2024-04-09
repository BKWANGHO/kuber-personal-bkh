package com.turing.api.board.model;


import com.turing.api.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class BoardDto {

    private Long id;
    private String boardName;
    private String boardType;
    private String regDate;
    private String modDate;
    private List<Article> articles = new ArrayList<>();

}
