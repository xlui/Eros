package style.dx.eros.service;

import style.dx.eros.entity.Comment;

import java.util.List;

public interface CommentService extends CommonService<Comment, Integer> {
	List<Comment> findByArticleId(Integer articleId);

	List<Comment> findByUserId(Integer userId);

	void save(Comment comment);
}
