package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import style.dx.eros.entity.Tag;
import style.dx.eros.service.TagService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {
	@Autowired
	private TagService tagService;

	@RequestMapping
	public String getTags(Model model) {
		model.addAttribute("tags", tagService.getTags());
		return "tag";
	}

	@RequestMapping("/{tagName}")
	public String getTagByName(@PathVariable String tagName, Model model) {
		List<Tag> tags = new ArrayList<>();
		tags.add(tagService.getTagByName(tagName));
		model.addAttribute("tags", tags);
		return "tag";
	}
}
