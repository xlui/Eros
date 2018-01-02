package style.dx.eros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import style.dx.eros.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
	Tag getByTagName(String tagName);
}
