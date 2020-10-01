package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Status;

import java.util.List;

public interface StatusRepository extends CrudRepository<Status, Integer> {
    List<Status> findAll();

    Status findById(int id);

}
