package com.turing.api.article;

import com.turing.api.common.component.MessengerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ArticleController {
    private final ArticleService service;

    @GetMapping("/api/all-articles")
    public Map<?, ?> findAll() {
        Map<String, Object> map = new HashMap<>();

        List<ArticleDto> list = service.findAll();
        map.put("result", list);
        System.out.println("리스트 몇개?"+list.size());
        return map;
    }


}
