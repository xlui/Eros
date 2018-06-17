package style.dx.eros.service;

import style.dx.eros.entity.User;

public interface UserService extends CommonService<User, Integer> {
	User findByUsername(String username);

	void save(User user);
}
