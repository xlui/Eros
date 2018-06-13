package style.dx.eros.service;

import style.dx.eros.entity.Tag;

public interface TagService extends CommonService<Tag, Integer> {
	Tag findByName(String tag);
}
