package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Priority;

public interface PriorityRepository extends CrudRepository<Priority, Integer> {
}
