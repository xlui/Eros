package style.dx.eros.dao;

import style.dx.eros.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	Article findArticleById(Long id);

	Article findArticleByIdLessThan(Long id);

	Article findArticleByIdGreaterThan(Long id);
}
