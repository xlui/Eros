package style.dx.eros.web;

import style.dx.eros.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Autowired
	ArticleRepository articleRepository;

	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		model.addAttribute("articles", articleRepository.findAll());
		return "index";
	}
}
