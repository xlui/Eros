package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import style.dx.eros.entity.Article;
import style.dx.eros.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "/article/{id}")
	public String article(@PathVariable Long id, Model model) {
		model.addAttribute("article", articleService.getArticleById(id));
		return "article";
	}
}
