package style.dx.eros.entity;

import style.dx.eros.util.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class Article  implements Serializable {
    public static final long serialVersionID = 1L;
    private Integer id;
    private String title;
    private String content;
    private Date create_date;
    private Date update_date;
    private Integer sort_id;

    public Article() {
    }

    public Article(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        create_date = new Date();
        update_date = new Date();
    }

    public Article(Integer id, String title, String content, Date create_date, Date update_date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCreate_date() {
        return DateUtils.toString(create_date);
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_date() {
        return DateUtils.toString(update_date);
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Integer getSort_id() {
        return sort_id;
    }

    public void setSort_id(Integer sort_id) {
        this.sort_id = sort_id;
    }
}
