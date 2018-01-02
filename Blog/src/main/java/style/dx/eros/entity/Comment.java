package style.dx.eros.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String content;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Article article;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	public Comment() {
		super();
	}

	public Comment(String content, Article article, User user) {
		this.content = content;
		this.article = article;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
