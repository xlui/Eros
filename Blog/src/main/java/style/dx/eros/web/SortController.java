package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import style.dx.eros.service.SortService;

@Controller
@RequestMapping("/sort")
public class SortController {
	@Autowired
	private SortService sortService;

	@RequestMapping
	public String getSorts(Model model) {
		model.addAttribute("sorts", sortService.getSorts());
		return "sort";
	}
}
