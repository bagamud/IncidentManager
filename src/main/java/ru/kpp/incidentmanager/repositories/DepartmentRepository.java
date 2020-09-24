package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Department;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    List<Department> findAll();

    Department findById(int id);
}
