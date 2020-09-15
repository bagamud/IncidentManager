package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    Users findByUsername(String username);

//    List<Users> findAllByRoleIsNot(int role);

}
