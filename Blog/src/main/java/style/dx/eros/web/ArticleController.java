package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import style.dx.eros.entity.Article;
import style.dx.eros.service.ArticleService;
import style.dx.eros.utils.DateUtils;

import java.text.ParseException;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "/{id}")
	public String article(@PathVariable Long id, Model model) {
		Article article = articleService.getArticleById(id);
		Article previousArticle = null;
		Article nextArticle = null;
		try {
			previousArticle = articleService.getPreviousArticle(DateUtils.toDate(article.getDate()));
			nextArticle = articleService.getNextArticle(DateUtils.toDate(article.getDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("article", article);
		model.addAttribute("previous", previousArticle);
		model.addAttribute("next", nextArticle);
		return "article";
	}
}
