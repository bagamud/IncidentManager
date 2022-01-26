package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Incident;

import java.util.List;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {
    List<Incident> findAll();

    List<Incident> findAllByStatus_DoneOrderById(boolean status_done);

    List<Incident> findAllByOrderById();

    Incident findById(int id);
}
