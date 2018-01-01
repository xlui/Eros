package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.Sort;
import style.dx.eros.repository.SortRepository;
import style.dx.eros.service.SortService;

import java.util.List;

@Service
public class SortServiceImpl implements SortService {
	@Autowired
	private SortRepository sortRepository;

	public List<Sort> getSorts() {
		return sortRepository.findAll();
	}
}
