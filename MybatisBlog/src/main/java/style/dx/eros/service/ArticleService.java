package style.dx.eros.service;

import style.dx.eros.entity.Article;

import java.util.List;

public interface ArticleService extends CommonService<Article, Integer> {
    List<Article> findAll(int current, int pageSize);
}
