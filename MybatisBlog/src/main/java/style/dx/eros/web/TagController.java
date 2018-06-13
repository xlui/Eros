package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import style.dx.eros.entity.Tag;
import style.dx.eros.service.ArticleService;
import style.dx.eros.service.TagService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {
	private final TagService tagService;
	private final ArticleService articleService;

	@Autowired
	public TagController(TagService tagService, ArticleService articleService) {
		this.tagService = tagService;
		this.articleService = articleService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getTags(Model model) {
		List<Tag> tags = tagService.findAll();
		tags.parallelStream().forEach(tag -> tag.setArticles(articleService.findByTagId(tag.getId())));
		model.addAttribute("tags", tags);
		return "tag";
	}

	@RequestMapping(value = "/{tag}", method = RequestMethod.GET)
	public String getTag(@PathVariable("tag") String name, Model model) {
		Tag tag = tagService.findByName(name);
		tag.setArticles(articleService.findByTagId(tag.getId()));
		model.addAttribute("tags", Collections.singletonList(tag));
		return "tag";
	}
}
