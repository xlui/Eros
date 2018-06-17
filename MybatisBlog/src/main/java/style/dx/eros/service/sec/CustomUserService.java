package style.dx.eros.service.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import style.dx.eros.entity.User;
import style.dx.eros.service.UserService;

public class CustomUserService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userService.findByUsername(s);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在！");
		}
		return user;
	}
}
