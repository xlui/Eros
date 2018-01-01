package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import style.dx.eros.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		model.addAttribute("articles", articleService.getArticles());
		return "index";
	}
}
