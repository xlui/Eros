package style.dx.eros.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import style.dx.eros.entity.Article;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface ArticleMapper {
    @Select("SELECT * FROM article")
    @Results({
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "create_date", column = "create_date", javaType = Date.class),
            @Result(property = "update_date", column = "update_date", javaType = Date.class)
    })
    List<Article> findAll();

    @Select("SELECT * FROM article LIMIT #{current}, #{pageSize}")
    List<Article> findAllWithPage(@Param("current") int current, @Param("pageSize") int pageSize);

    @Select("SELECT * FROM article WHERE id=#{id}")
    Article findById(Integer id);
}
