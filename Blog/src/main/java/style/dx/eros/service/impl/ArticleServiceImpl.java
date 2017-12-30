package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.Article;
import style.dx.eros.repository.ArticleRepository;
import style.dx.eros.service.ArticleService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public List<Article> getArticles() {
		return articleRepository.findAll();
	}

	@Override
	public Article getArticleById(Long id) {
		return articleRepository.findArticleById(id);
	}
}
