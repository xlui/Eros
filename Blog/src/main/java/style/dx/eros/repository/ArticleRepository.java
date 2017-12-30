package style.dx.eros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import style.dx.eros.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	Article findArticleById(Long id);

}
