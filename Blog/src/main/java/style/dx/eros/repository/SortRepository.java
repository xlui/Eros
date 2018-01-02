package style.dx.eros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import style.dx.eros.entity.Sort;

public interface SortRepository extends JpaRepository<Sort, Long> {
	Sort getSortBySortName(String sortName);
}
