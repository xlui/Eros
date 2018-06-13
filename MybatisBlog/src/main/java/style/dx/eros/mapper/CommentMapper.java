package style.dx.eros.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import style.dx.eros.entity.Comment;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface CommentMapper {
	@Select("SELECT * FROM comment")
	@Results({
			@Result(property = "id", column = "id", javaType = Integer.class),
			@Result(property = "content", column = "content", javaType = String.class),
			@Result(property = "date", column = "date", javaType = Date.class)
	})
	List<Comment> findAll();

	@Select("SELECT * FROM comment WHERE id = #{id}")
	Comment findById(Integer id);

	@Select("SELECT * FROM comment WHERE article_id = #{articleId}")
	List<Comment> findByArticleId(Integer articleId);

	@Select("SELECT * FROM comment WHERE user_id = #{user_id}")
	List<Comment> findByUserId(Integer userId);

	@Insert("INSERT INTO comment(content, date, article_id, user_id) VALUES (#{content}, #{date}, #{article_id}, #{user_id})")
	void save(Comment comment);
}
