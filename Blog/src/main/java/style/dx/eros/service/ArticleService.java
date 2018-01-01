package style.dx.eros.service;

import style.dx.eros.entity.Article;

import java.util.List;

public interface ArticleService {
	List<Article> getArticles();

	Article getArticleById(Long id);
}
