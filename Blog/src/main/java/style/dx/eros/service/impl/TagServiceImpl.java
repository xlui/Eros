package style.dx.eros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import style.dx.eros.entity.Tag;
import style.dx.eros.repository.TagRepository;
import style.dx.eros.service.TagService;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagRepository tagRepository;

	public List<Tag> getTags() {
		return tagRepository.findAll();
	}

	@Override
	public Tag getTagByName(String tagName) {
		return tagRepository.getByTagName(tagName);
	}
}
