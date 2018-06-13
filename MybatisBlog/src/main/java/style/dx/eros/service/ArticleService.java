package style.dx.eros.service;

import style.dx.eros.entity.Article;

import java.util.Date;
import java.util.List;

public interface ArticleService extends CommonService<Article, Integer> {
    List<Article> findAll(int current, int pageSize);

	List<Article> findBySortId(Integer sortId);

	List<Article> findByTagId(Integer tagId);

	Article findDateBefore(Date date);

	Article findDateAfter(Date date);
}
