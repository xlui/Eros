package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.User;
import style.dx.eros.mapper.UserMapper;
import style.dx.eros.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	@Cacheable(value = "users", key = "'all'")
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	@Cacheable(value = "user", key = "'id-' + #id")
	public User findById(Integer id) {
		return userMapper.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}

	@Override
	public void save(User user) {
		userMapper.save(user);
	}
}
