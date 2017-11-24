package dx.style.eros.dao;

import dx.style.eros.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	Article findArticleById(int id);

	Article findArticleByIdLessThan(int id);

	Article findArticleByIdGreaterThan(int id);
}
