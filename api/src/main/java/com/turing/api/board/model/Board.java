package com.turing.api.board.model;

import java.util.List;

import com.turing.api.common.model.BaseEntity;
import jakarta.persistence.*;
import com.turing.api.article.model.Article;
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

    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Article> articles;


}

