package com.turing.api.board;

import java.util.List;

import com.turing.api.common.BaseEntity;
import jakarta.persistence.*;
import com.turing.api.article.Article;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "boards")
@Builder
@AllArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;
    private String boardName;
    private String boardType;

    @OneToMany(mappedBy = "board")
    private List<Article> articles;


}

