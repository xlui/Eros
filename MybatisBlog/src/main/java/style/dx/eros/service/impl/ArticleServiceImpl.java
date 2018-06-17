package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.Article;
import style.dx.eros.mapper.ArticleMapper;
import style.dx.eros.service.ArticleService;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
	private final ArticleMapper articleMapper;

	@Autowired
	public ArticleServiceImpl(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}

	@Override
	@Cacheable(value = "articles", key = "'all'")
	public List<Article> findAll() {
		return articleMapper.findAll();
	}

	@Override
	public int count() {
		return articleMapper.count();
	}

	@Override
	@Cacheable(value = "articles", key = "'page-' + (#pr.pageNumber * #pr.pageSize + #pr.pageNumber)")
	public List<Article> findAllWithPage(PageRequest pr) {
		return articleMapper.findAllWithPage(pr.getPageNumber() * pr.getPageSize(), pr.getPageSize());
	}

	@Override
	@Cacheable(value = "articles", key = "'sort-' + #sortId")
	public List<Article> findBySortId(Integer sortId) {
		return articleMapper.findBySortId(sortId);
	}

	@Override
	@Cacheable(value = "articles", key = "'tag-' + #tagId")
	public List<Article> findByTagId(Integer tagId) {
		return articleMapper.findByTagId(tagId);
	}

	@Override
	@Cacheable(value = "article", key = "'find-' + #integer")
	public Article findById(Integer integer) {
		return articleMapper.findById(integer);
	}

	@Override
	@Cacheable(value = "article", key = "'before-' + #date")
	public Article findDateBefore(Date date) {
		return articleMapper.findDateBefore(date);
	}

	@Override
	@Cacheable(value = "article", key = "'after-' + #date")
	public Article findDateAfter(Date date) {
		return articleMapper.findDateAfter(date);
	}
}
