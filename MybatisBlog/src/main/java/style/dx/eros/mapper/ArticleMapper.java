package style.dx.eros.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import style.dx.eros.entity.Article;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface ArticleMapper {
	@Select("SELECT COUNT(*) FROM article")
	int count();

	@Select("SELECT * FROM article")
	@Results({
			@Result(property = "id", column = "id", javaType = Integer.class),
			@Result(property = "create_date", column = "create_date", javaType = Date.class),
			@Result(property = "update_date", column = "update_date", javaType = Date.class)
	})
	List<Article> findAll();

	@Select("SELECT * FROM article LIMIT #{current}, #{pageSize}")
	List<Article> findAllWithPage(@Param("current") int current, @Param("pageSize") int pageSize);

	@Select("SELECT * FROM article WHERE id=#{id}")
	Article findById(Integer id);

	@Select("SELECT * FROM article WHERE sort_id=#{id}")
	List<Article> findBySortId(Integer id);

	@Select("SELECT a.id, a.title, a.content, a.create_date, a.update_date, a.sort_id " +
			"FROM article AS a INNER JOIN st_article_tag AS t ON a.id = t.article_id " +
			"WHERE t.tag_id = #{id}")
	List<Article> findByTagId(Integer id);

	@Select("SELECT * FROM article WHERE create_date < #{date} ORDER BY create_date DESC LIMIT 1")
	Article findDateBefore(Date date);

	@Select("SELECT * FROM article WHERE create_date > #{date} LIMIT 1")
	Article findDateAfter(Date date);
}
