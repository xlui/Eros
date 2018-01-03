package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.User;
import style.dx.eros.repository.UserRepository;
import style.dx.eros.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
