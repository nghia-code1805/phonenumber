package nghia.phone.service;

import nghia.phone.model.Category;
import nghia.phone.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPhoneService {

    Page<Phone> findAll(Pageable pageable);
    Phone findById(Long id);
    void save(Phone phone);
    void remove(Long id);

    Iterable<Phone> findAllByCategory(Category category);
    Page<Phone> findAllByPhoneName(String phoneName, Pageable pageable);
}
