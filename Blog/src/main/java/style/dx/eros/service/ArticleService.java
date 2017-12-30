package style.dx.eros.service;

import style.dx.eros.entity.Article;

import java.util.List;

public interface ArticleService {
	public List<Article> getArticles();

	public Article getArticleById(Long id);
}
