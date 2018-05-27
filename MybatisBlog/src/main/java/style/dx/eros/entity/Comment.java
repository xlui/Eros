package style.dx.eros.entity;

import java.io.Serializable;

public class Comment implements Serializable {
    public static final long serialVersionID = 1L;
    private Long id;
    private String content;
    private Long article_id;
    private Long user_id;

    public Comment() {
    }

    public Comment(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Comment(Long id, String content, Long article_id, Long user_id) {
        this.id = id;
        this.content = content;
        this.article_id = article_id;
        this.user_id = user_id;
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

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
