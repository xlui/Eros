package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import style.dx.eros.entity.Article;
import style.dx.eros.entity.Comment;
import style.dx.eros.entity.User;
import style.dx.eros.service.ArticleService;
import style.dx.eros.service.CommentService;
import style.dx.eros.service.UserService;
import style.dx.eros.util.DateUtils;
import style.dx.eros.util.LogUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;

	@RequestMapping
	public String articles() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/{id}")
	public String article(@PathVariable Long id, Model model) {
		Article article = articleService.getArticleById(id);
		Article previousArticle = null;
		Article nextArticle = null;
		try {
			previousArticle = articleService.getPreviousArticle(DateUtils.toDate(article.getDate()));
			nextArticle = articleService.getNextArticle(DateUtils.toDate(article.getDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("article", article);
		model.addAttribute("comment_form", new Comment());
		model.addAttribute("comments", article.getCommentList());
		model.addAttribute("previous", previousArticle);
		model.addAttribute("next", nextArticle);
		return "article";
	}

	@RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
	public String addComment(@PathVariable Long id, @ModelAttribute Comment comment, HttpServletRequest request) {
		if (comment.getContent().trim().length() == 0) {
			LogUtils.getInstance().info("评论为空，不保存！");
		} else {
			User user = (User) request.getSession().getAttribute("user");
			comment.setId(null);
			comment.setArticle(articleService.getArticleById(id));
			comment.setUser(userService.getUserByUsername(user.getUsername()));
			comment.setDate(new Date());
			commentService.save(comment);
		}
		return "redirect:/article/" + id;
	}
}
