package style.dx.eros.service;

import org.springframework.data.domain.PageRequest;
import style.dx.eros.entity.Article;

import java.util.Date;
import java.util.List;

public interface ArticleService extends CommonService<Article, Integer> {
	int count();

	List<Article> findAllWithPage(PageRequest pageRequest);

	List<Article> findBySortId(Integer sortId);

	List<Article> findByTagId(Integer tagId);

	Article findDateBefore(Date date);

	Article findDateAfter(Date date);
}
