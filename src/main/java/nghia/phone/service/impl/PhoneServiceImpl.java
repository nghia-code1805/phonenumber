package nghia.phone.service.impl;

import nghia.phone.model.Category;
import nghia.phone.model.Phone;
import nghia.phone.repository.IPhoneRepository;
import nghia.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PhoneServiceImpl implements IPhoneService {

    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return phoneRepository.findAll(pageable);
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findOne(id);
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void remove(Long id) {
        phoneRepository.delete(id);
    }

    @Override
    public Iterable<Phone> findAllByCategory(Category category) {
        return phoneRepository.findAllByCategory(category);
    }

    @Override
    public Page<Phone> findAllByPhoneName(String phoneName, Pageable pageable) {
        return phoneRepository.findAllByPhoneName(phoneName,pageable);
    }
}
