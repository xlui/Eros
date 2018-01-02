package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import style.dx.eros.service.ArticleService;

@Controller
@RequestMapping(value = {"/", "/index"})
public class IndexController {
	@Autowired
	private ArticleService articleService;
	private int defaultPageSize = 2;

	@RequestMapping
	public String index(Model model) {
		model.addAttribute("articles", articleService.getArticles(new PageRequest(0, defaultPageSize)));
		return "index";
	}

	@RequestMapping(value = "/page/{p}")
	public String index(@PathVariable int p, Model model) {
		model.addAttribute("articles", articleService.getArticles(new PageRequest(p - 1, defaultPageSize)));
		return "index";
	}
}
