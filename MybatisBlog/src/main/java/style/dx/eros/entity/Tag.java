package style.dx.eros.entity;

import java.io.Serializable;

public class Tag implements Serializable {
    public static final long serialVersionID = 1L;
    private Long id;
    private String name;

    public Tag() {
    }

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag[id=" + id + ", name=" + name + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
