package dx.style.eros.web;

import dx.style.eros.dao.ArticleRepository;
import dx.style.eros.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;

	@RequestMapping("/")
	public List<Article> index() {
		return articleRepository.findAll();
	}
}
