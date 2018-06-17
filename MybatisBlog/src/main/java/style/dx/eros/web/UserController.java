package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import style.dx.eros.entity.Comment;
import style.dx.eros.entity.User;
import style.dx.eros.service.UserService;

import javax.servlet.http.HttpServletRequest;
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@NotNull @ModelAttribute User user, Model model, HttpServletRequest request) {
		User checkUser = userService.findByUsername(user.getUsername());
		if (checkUser != null && checkUser.getPassword().equals(user.getPassword())) {
			request.getSession().setAttribute("user", checkUser);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "username or password is invalid!");
			return "login";
		}
	}

	@RequestMapping(value = "/login/to/article/{id}", method = RequestMethod.GET)
	public String getLoginTo(@PathVariable Integer id, Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("to", true);
		return "login";
	}

	@RequestMapping(value = "/login/to/article/{id}", method = RequestMethod.POST)
	public String postLoginTo(@PathVariable Integer id, @NotNull @ModelAttribute User user, Model model, HttpServletRequest request) {
		String result = postLogin(user, model, request);
		if (result.equals("login")) {
			model.addAttribute("msg", "username or password is invalid!");
			return getLoginTo(id, model);
		} else {
			model.addAttribute("comment_form", new Comment());
			return "redirect:/article/{id}";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("user", null);
		return "redirect:/";
	}

	@RequestMapping(value = "/user/{username}")
	public String user(@PathVariable String username, Model model) {
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "user";
	}
}
