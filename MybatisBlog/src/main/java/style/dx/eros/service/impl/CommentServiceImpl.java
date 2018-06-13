package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.Comment;
import style.dx.eros.mapper.CommentMapper;
import style.dx.eros.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
	private final CommentMapper commentMapper;

	@Autowired
	public CommentServiceImpl(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

	@Override
	@Cacheable(value = "comments", key = "'all'")
	public List<Comment> findAll() {
		return commentMapper.findAll();
	}

	@Override
	@Cacheable(value = "comments", key = "'article-' + #articleId")
	public List<Comment> findByArticleId(Integer articleId) {
		return commentMapper.findByArticleId(articleId);
	}

	@Override
	@Cacheable(value = "comments", key = "'user-' + #userId")
	public List<Comment> findByUserId(Integer userId) {
		return commentMapper.findByUserId(userId);
	}

	@Override
	@CachePut(value = "comment", key = "#comment.id")
	public void save(Comment comment) {
		commentMapper.save(comment);
	}

	@Override
	@Cacheable(value = "comment", key = "#id")
	public Comment findById(Integer id) {
		return commentMapper.findById(id);
	}
}
