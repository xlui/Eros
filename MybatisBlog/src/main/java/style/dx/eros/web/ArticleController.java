package style.dx.eros.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import style.dx.eros.entity.Article;
import style.dx.eros.entity.Comment;
import style.dx.eros.service.ArticleService;
import style.dx.eros.service.CommentService;
import style.dx.eros.service.SortService;
import style.dx.eros.service.UserService;
import style.dx.eros.util.DateUtils;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	private final ArticleService articleService;
	private final SortService sortService;
	private final CommentService commentService;
	private final UserService userService;

	@Autowired
	public ArticleController(ArticleService articleService, SortService sortService, CommentService commentService, UserService userService) {
		this.articleService = articleService;
		this.sortService = sortService;
		this.commentService = commentService;
		this.userService = userService;
	}

	@RequestMapping
	public String getArticles() {
		return "forward:/";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getArticle(@PathVariable Integer id, Model model) throws ParseException {
		Article article = articleService.findById(id);
		List<Comment> comments = commentService.findByArticleId(article.getId());
		comments.parallelStream().forEach(comment -> comment.setUser(userService.findById(comment.getUser_id())));

		model.addAttribute("article", article);
		model.addAttribute("sort", sortService.findById(article.getSort_id()));
		model.addAttribute("comments", comments);
		model.addAttribute("comment_form", new Comment());
		model.addAttribute("previous", articleService.findDateBefore(DateUtils.toDate(article.getCreate_date())));
		model.addAttribute("next", articleService.findDateAfter(DateUtils.toDate(article.getCreate_date())));
		return "article";
	}
}
