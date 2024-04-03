package com.turing.api.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ArticleService {

    List<Article> findAll();
}
