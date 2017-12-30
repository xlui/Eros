package style.dx.eros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import style.dx.eros.service.ArticleService;

@Controller
public class IndexController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		System.out.println(articleService.getArticles());
		model.addAttribute("articles", articleService.getArticles());
		return "index";
	}
}
