package style.dx.eros.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import style.dx.eros.entity.Article;

import java.util.List;

public interface ArticleService {
	Page<Article> getArticles(PageRequest pagedRequest);

	Article getArticleById(Long id);
}
