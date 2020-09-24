package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    List<Category> findAll();

    Category findById(int id);
}
