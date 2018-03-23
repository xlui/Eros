package style.dx.eros.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import style.dx.eros.util.MD5Utils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String md5;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<Comment> commentList;

	public User() {
		super();
	}

	public User(String username, String password, String md5, List<Comment> commentList) {
		this.username = username;
		this.password = password;
		this.md5 = md5;
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "User[id = " + id + ", username = " + username + ", password = " + password + ", md5 = " + md5 + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5() {
		this.md5 = MD5Utils.getMD5(username);
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
