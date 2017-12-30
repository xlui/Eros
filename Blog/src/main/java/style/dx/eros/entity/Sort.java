package style.dx.eros.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Sort implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String sortName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sort")
	private Set<Article> articleSet;

	public Sort() {
		super();
	}

	public Sort(String sortName, Set<Article> articleSet) {
		this.sortName = sortName;
		this.articleSet = articleSet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public Set<Article> getArticleSet() {
		return articleSet;
	}

	public void setArticleSet(Set<Article> articleSet) {
		this.articleSet = articleSet;
	}
}
