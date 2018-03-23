package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import style.dx.eros.config.Const;
import style.dx.eros.service.ArticleService;

@Controller
public class IndexController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		model.addAttribute("articles", articleService.getArticles(new PageRequest(0, Const.defaultPageSize)));
		return "index";
	}

	@RequestMapping(value = "/page/{p}")
	public String index(@PathVariable int p, Model model) {
		model.addAttribute("articles", articleService.getArticles(new PageRequest(p - 1, Const.defaultPageSize)));
		return "index";
	}
}
