package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import style.dx.eros.entity.Sort;
import style.dx.eros.service.ArticleService;
import style.dx.eros.service.SortService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/sort")
public class SortController {
	private final SortService sortService;
	private final ArticleService articleService;

	@Autowired
	public SortController(SortService sortService, ArticleService articleService) {
		this.sortService = sortService;
		this.articleService = articleService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAllSorts(Model model) {
		List<Sort> sorts = sortService.findAll();
		sorts.parallelStream()
				.forEach(sort -> sort.setArticles(articleService.findBySortId(sort.getId())));
		model.addAttribute("sorts", sorts);
		return "sort";
	}

	@RequestMapping(value = "/{sort}", method = RequestMethod.GET)
	public String getSortByName(@PathVariable("sort") String name, Model model) {
		Sort sort = sortService.findByName(name);
		sort.setArticles(articleService.findBySortId(sort.getId()));
		model.addAttribute("sorts", Collections.singletonList(sort));
		return "sort";
	}
}
