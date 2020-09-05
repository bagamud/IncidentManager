package ru.kpp.incidentmanager.controllers;

import org.springframework.web.bind.annotation.*;
import ru.kpp.incidentmanager.entity.Users;
import ru.kpp.incidentmanager.repositories.UsersRepository;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public @ResponseBody
    Iterable<Users> getUsers() {

        return usersRepository.findAll();
    }

    @GetMapping(path = "{login}")
    Users getUserByLogin(@PathVariable String login) {
        return usersRepository.findUsersByLogin(login);
    }
}
