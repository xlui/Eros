package style.dx.eros.service;

import java.util.List;

public interface CommonService<T, K> {
	List<T> findAll();

	T findById(K k);
}
