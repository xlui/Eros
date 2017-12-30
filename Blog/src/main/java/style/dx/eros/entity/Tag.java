package style.dx.eros.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
	private Set<Article> articleSet;

	public Tag() {
		super();
	}

	public Tag(String tagName, Set<Article> articleSet) {
		this.tagName = tagName;
		this.articleSet = articleSet;
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

	public Set<Article> getArticleSet() {
		return articleSet;
	}

	public void setArticleSet(Set<Article> articleSet) {
		this.articleSet = articleSet;
	}
}

