package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Incident;

import java.sql.Timestamp;
import java.util.List;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {

    List<Incident> findByStatusNotLike(int status);

    List<Incident> findByDate(Timestamp date);

    List<Incident> findByEngineer(Integer user);
}
