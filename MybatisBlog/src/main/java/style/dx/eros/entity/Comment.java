package style.dx.eros.entity;

import style.dx.eros.util.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    public static final long serialVersionID = 1L;
    private Integer id;
    private String content;
    private Date date;
    private Integer article_id;
    private Integer user_id;

    public Comment() {
    }

    public Comment(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Comment(Integer id, String content, Date date, Integer article_id, Integer user_id) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.article_id = article_id;
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return DateUtils.toString(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
