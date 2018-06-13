package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import style.dx.eros.conf.Const;
import style.dx.eros.service.ArticleService;

@Controller
public class IndexController {
    private final ArticleService articleService;

    @Autowired
	public IndexController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("articles", articleService.findAll(0, Const.defaultPageSize));
        return "index";
    }
}
