package com.turing.api.user;


import com.turing.api.article.Article;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Log4j
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private Long addressId;
    private String job;
    private double height;
    private double weight;
    @Builder.Default
    private List<Article> articles = new ArrayList<>();
}
