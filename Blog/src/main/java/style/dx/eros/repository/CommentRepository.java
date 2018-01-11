package style.dx.eros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import style.dx.eros.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
