package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.Article;
import style.dx.eros.repository.ArticleRepository;
import style.dx.eros.service.ArticleService;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Page<Article> getArticles(PageRequest pageRequest) {
		return articleRepository.findAll(pageRequest);
	}

	@Override
	public Article getArticleById(Long id) {
		return articleRepository.findArticleById(id);
	}

	@Override
	public Article getPreviousArticle(Date date) {
		return articleRepository.findFirstByDateBefore(date);
	}

	@Override
	public Article getNextArticle(Date date) {
		return articleRepository.findFirstByDateAfter(date);
	}
}
