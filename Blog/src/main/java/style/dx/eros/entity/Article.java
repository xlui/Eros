package style.dx.eros.entity;

import style.dx.eros.util.DateUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private String title;
	private String content;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sort_id")
	private Sort sort;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_tag_article", joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private List<Tag> tagList;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "article")
	private List<Comment> commentList;

	public Article() {
		super();
	}

	public Article(Date date, String title, String content, Sort sort, List<Tag> tagList, List<Comment> commentList) {
		this.date = date;
		this.title = title;
		this.content = content;
		this.sort = sort;
		this.tagList = tagList;
		this.commentList = commentList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return DateUtils.toString(date);
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

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
