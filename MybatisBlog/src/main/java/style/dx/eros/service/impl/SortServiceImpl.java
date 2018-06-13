package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.Sort;
import style.dx.eros.mapper.SortMapper;
import style.dx.eros.service.SortService;

import java.util.List;

@Service
public class SortServiceImpl implements SortService {
	private final SortMapper sortMapper;

	@Autowired
	public SortServiceImpl(SortMapper sortMapper) {
		this.sortMapper = sortMapper;
	}

	@Override
	@Cacheable(value = "sorts", key = "'all'")
	public List<Sort> findAll() {
		return sortMapper.findAll();
	}

	@Override
	@Cacheable(value = "sort", key = "'name-' + #sort")
	public Sort findByName(String sort) {
		return sortMapper.findByName(sort);
	}

	@Override
	@Cacheable(value = "sort", key = "'id-' + #id")
	public Sort findById(Integer id) {
		return sortMapper.findById(id);
	}
}
