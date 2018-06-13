package style.dx.eros.service;

import style.dx.eros.entity.Sort;

public interface SortService extends CommonService<Sort, Integer> {
	Sort findByName(String sort);
}
