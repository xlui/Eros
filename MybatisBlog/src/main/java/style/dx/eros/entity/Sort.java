package style.dx.eros.entity;

import java.io.Serializable;

public class Sort implements Serializable {
    public static final long serialVersionID = 1L;
    private Integer id;
    private String name;

    public Sort() {
    }

    public Sort(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sort[id=" + id + ", name=" + name + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
