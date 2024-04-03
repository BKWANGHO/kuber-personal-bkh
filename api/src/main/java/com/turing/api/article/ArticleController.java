package com.turing.api.article;

import com.turing.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ArticleController {
    private final ArticleService service;

    @GetMapping("/api/all-articles")
    public Map<?, ?> findAll() {
        Map<String, Object> map = new HashMap<>();

//        @SuppressWarnings("unchecked")
        List<Article> list = service.findAll();
//        list = service.findAll();
        list.add(Article.builder()
                .id(1L)
                .title("타임스크립트")
                .content("너무 어렵다")
                .registerDate("24-03-27")
                .build());
        map.put("messege", Messenger.SUCCESS);
        map.put("result", list);
        System.out.println("리스트 몇개?"+list.size());
        return map;
    }


}
