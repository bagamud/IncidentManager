package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Priority;

import java.util.List;

public interface PriorityRepository extends CrudRepository<Priority, Integer> {
    List<Priority> findAll();

    Priority findById(int id);
}
