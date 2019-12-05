package nghia.phone.repository;

import nghia.phone.model.Category;
import nghia.phone.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPhoneRepository extends PagingAndSortingRepository<Phone, Long> {

    Iterable<Phone> findAllByCategory(Category category);
    Page<Phone> findAllByPhoneName(String phoneName, Pageable pageable);
}
