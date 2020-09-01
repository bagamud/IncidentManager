package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
