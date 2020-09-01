package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
