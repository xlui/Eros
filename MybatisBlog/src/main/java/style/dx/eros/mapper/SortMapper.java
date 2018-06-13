package style.dx.eros.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import style.dx.eros.entity.Sort;

import java.util.List;

@Mapper
@Component
public interface SortMapper {
	@Select("SELECT * FROM sort")
	@Results({
			@Result(property = "id", column = "id", javaType = Integer.class),
			@Result(property = "name", column = "name", javaType = String.class)
	})
	List<Sort> findAll();

	@Select("SELECT * FROM sort WHERE id=#{id}")
	Sort findById(Integer id);

	@Select("SELECT * FROm sort WHERE name=#{name}")
	Sort findByName(@Param(value = "name") String sort);
}
