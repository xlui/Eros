package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.Article;
import style.dx.eros.mapper.ArticleMapper;
import style.dx.eros.service.ArticleService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    @Cacheable(value = "all-articles")
    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    @Override
    @Cacheable(value = "single-article", key = "#integer")
    public Article findById(Integer integer) {
        return articleMapper.findById(integer);
    }

    @Override
    @Cacheable(value = "page-articles", key = "#current+#pageSize")
    public List<Article> findAll(int current, int pageSize) {
        return articleMapper.findAllWithPage(current, pageSize);
    }
}
