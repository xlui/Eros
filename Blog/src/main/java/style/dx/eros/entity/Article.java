package style.dx.eros.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private String title;
	private String content;

	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "sort_id")
	private Sort sort;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_tag_article", joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private Set<Tag> tagSet;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
	private Set<Comment> commentSet;

	public Article() {
		super();
	}

	public Article(Date date, String title, String content, Sort sort, Set<Tag> tagSet, Set<Comment> commentSet) {
		this.date = date;
		this.title = title;
		this.content = content;
		this.sort = sort;
		this.tagSet = tagSet;
		this.commentSet = commentSet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public Set<Tag> getTagSet() {
		return tagSet;
	}

	public void setTagSet(Set<Tag> tagSet) {
		this.tagSet = tagSet;
	}

	public Set<Comment> getCommentSet() {
		return commentSet;
	}

	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}
}
