package style.dx.eros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import style.dx.eros.entity.Article;

import java.util.Date;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	Article findArticleById(Long id);

	Article findFirstByDateBefore(Date date);

	Article findFirstByDateAfter(Date date);
}
