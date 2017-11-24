package dx.style.eros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String author;
	private String sort;
	private String time;
	private String content;

	public Article() {
		super();
	}

	public Article(Long id, String title, String author, String sort, String time, String content) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.sort = sort;
		this.time = time;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
