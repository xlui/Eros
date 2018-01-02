package style.dx.eros.service;

import style.dx.eros.entity.Sort;

import java.util.List;

public interface SortService {
	List<Sort> getSorts();

	Sort getSortBySortName(String sortName);
}
