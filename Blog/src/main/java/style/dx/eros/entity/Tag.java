package style.dx.eros.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String tagName;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_tag_article", joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"))
	@JsonIgnore
	private List<Article> articleList;

	public Tag() {
		super();
	}

	public Tag(String tagName, List<Article> articleList) {
		this.tagName = tagName;
		this.articleList = articleList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
}

