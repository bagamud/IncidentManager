package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Incident;
import ru.kpp.incidentmanager.entity.Status;

import java.util.List;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {
//    List<Incident> findAll();
List<Incident> findAllByStatusIsNot(Status status);

    Incident findById(int id);
}
