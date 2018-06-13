package style.dx.eros.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import style.dx.eros.entity.User;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
	@Select("SELECT * FROM user")
	List<User> findAll();

	@Select("SELECT * FROM user WHERE id = #{id}")
	User findById(Integer id);
}
