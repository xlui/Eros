package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.Tag;
import style.dx.eros.mapper.TagMapper;
import style.dx.eros.service.TagService;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
	private final TagMapper tagMapper;

	@Autowired
	public TagServiceImpl(TagMapper tagMapper) {
		this.tagMapper = tagMapper;
	}

	@Override
	@Cacheable(value = "tags", key = "'all'")
	public List<Tag> findAll() {
		return tagMapper.findAll();
	}

	@Override
	@Cacheable(value = "tag", key = "'id-' + #id")
	public Tag findById(Integer id) {
		return tagMapper.findById(id);
	}

	@Override
	@Cacheable(value = "tag", key = "'tag-' + #tag")
	public Tag findByName(String tag) {
		return tagMapper.findByName(tag);
	}
}
