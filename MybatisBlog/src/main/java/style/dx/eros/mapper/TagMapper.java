package style.dx.eros.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import style.dx.eros.entity.Tag;

import java.util.List;

@Mapper
@Component
public interface TagMapper {
	@Select("SELECT * FROM tag")
	List<Tag> findAll();

	@Select("SELECT * FROM tag WHERE id=#{id}")
	Tag findById(Integer id);

	@Select("SELECT * FROM tag WHERE name=#{name}")
	Tag findByName(@Param("name") String tag);
}
