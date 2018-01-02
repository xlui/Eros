package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import style.dx.eros.entity.Sort;
import style.dx.eros.service.SortService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sorts")
public class SortController {
	@Autowired
	private SortService sortService;

	@RequestMapping
	public String getSorts(Model model) {
		model.addAttribute("sorts", sortService.getSorts());
		return "sort";
	}

	@RequestMapping("/{sortName}")
	public String getSortBySortName(@PathVariable String sortName, Model model) {
		List<Sort> sorts = new ArrayList<>();
		sorts.add(sortService.getSortBySortName(sortName));
		model.addAttribute("sorts", sorts);
		return "sort";
	}
}
