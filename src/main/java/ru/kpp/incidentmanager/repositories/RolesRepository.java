package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Roles;

public interface RolesRepository extends CrudRepository<Roles, Integer> {
}
