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
import style.dx.eros.utils.LogUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute User user, Model model) {
		if (userService.getUserByUsername(user.getUsername()) == null) {
			LogUtils.getLogger().info("User:\n" + user.toString());
			user.setMd5();
			userService.save(user);
			model.addAttribute("register", true);
			return "login";
		} else {
			model.addAttribute("failed", true);
			return "register";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, Model model, HttpServletRequest httpServletRequest) {
		User checkUser = userService.getUserByUsername(user.getUsername());
		if (checkUser != null && checkUser.getPassword().equals(user.getPassword())) {
			httpServletRequest.getSession().setAttribute("user", checkUser);
			LogUtils.getLogger().info("UserController: 设置 session.user 为登录用户");
			return "redirect:/";
		} else {
			model.addAttribute("msg", "username or password invalid!");
			return "login";
		}
	}

	@RequestMapping(value = "/loginTo/article/{id}", method = RequestMethod.GET)
	public String loginTo(@PathVariable Long id, Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("to", true);
		return "login";
	}

	@RequestMapping(value = "/loginTo/article/{id}", method = RequestMethod.POST)
	public String loginTo(@PathVariable Long id, @ModelAttribute User user, Model model, HttpServletRequest httpServletRequest) {
		String result = login(user, model, httpServletRequest);
		if (result.equals("login")) {
			model.addAttribute("msg", "username or password invalid!");
			return loginTo(id, model);
		} else {
			model.addAttribute("comment_form", new Comment());
			return "redirect:/article/" + id;
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest httpServletRequest) {
		httpServletRequest.getSession().setAttribute("user", null);
		return "redirect:/";
	}

	@RequestMapping(value = "/forget", method = RequestMethod.GET)
	public String forget() {
		return "forget";
	}

	@RequestMapping(value = "/forget", method = RequestMethod.POST)
	public String forget(Model model) {
		// todo: change password
		model.addAttribute("forget", true);
		return "forget";
	}

	@RequestMapping("/user/{username}")
	public String user(@PathVariable String username, Model model) {
		User user = userService.getUserByUsername(username);
		model.addAttribute("user", user);
		return "user";
	}
}
