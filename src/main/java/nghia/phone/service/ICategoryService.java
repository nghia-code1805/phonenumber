package nghia.phone.service;

import nghia.phone.model.Category;

public interface ICategoryService {

    Iterable<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void remove(Long id);
}
