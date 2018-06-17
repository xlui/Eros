package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import style.dx.eros.entity.User;
import style.dx.eros.service.UserService;

import javax.validation.constraints.NotNull;

@Controller
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(@NotNull @ModelAttribute User user, Model model) {
		if (userService.findByUsername(user.getUsername()) == null) {
			User newUser = new User(user.getUsername(), user.getPassword());
			userService.save(newUser);
			return "login";
		} else {
			model.addAttribute("failed", true);
			return "register";
		}
	}
}
