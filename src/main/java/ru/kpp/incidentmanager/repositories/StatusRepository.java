package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {
}
