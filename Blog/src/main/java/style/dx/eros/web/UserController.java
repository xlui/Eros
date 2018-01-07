package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		userService.save(user);
		model.addAttribute("register", true);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, Model model, HttpServletRequest httpServletRequest) {
		User checkUser = userService.getUserByUsername(user.getUsername());
		if (checkUser.getPassword().equals(user.getPassword())) {
			httpServletRequest.getSession().setAttribute("user", checkUser);
			LogUtils.getLogger().info("UserController: 设置 session.user 为登录用户");
			return "redirect:/";
		} else {
			model.addAttribute("msg", "username or password error!");
			return "login";
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
