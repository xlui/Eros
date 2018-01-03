package style.dx.eros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import style.dx.eros.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
