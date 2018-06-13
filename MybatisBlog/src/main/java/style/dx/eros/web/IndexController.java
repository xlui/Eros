package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import style.dx.eros.conf.Const;
import style.dx.eros.entity.Article;
import style.dx.eros.service.ArticleService;
import style.dx.eros.service.SortService;

import java.util.List;

@Controller
public class IndexController {
    private final ArticleService articleService;
    private final SortService sortService;

    @Autowired
    public IndexController(ArticleService articleService, SortService sortService) {
        this.articleService = articleService;
        this.sortService = sortService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        prepareArticleWithPage(0, model);
        return "index";
    }

    @RequestMapping(value = "/page/{p}", method = RequestMethod.GET)
    public String getPage(@PathVariable(value = "p") int page, Model model) {
        prepareArticleWithPage(page, model);
        return "index";
    }

    private void prepareArticleWithPage(int page, Model model) {
        List<Article> articles = articleService.findAllWithPage(new PageRequest(page - 1, Const.defaultPageSize));
        articles.forEach(article -> article.setSort(sortService.findById(article.getSort_id())));
        model.addAttribute("articles", articles);
        model.addAttribute("page", page - 1);
        model.addAttribute("total", articleService.count() / Const.defaultPageSize);
    }
}
