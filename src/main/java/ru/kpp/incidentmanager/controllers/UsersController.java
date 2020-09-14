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

    @GetMapping(path = "/{username}")
    public @ResponseBody
    Users getUser(@PathVariable String username) {
        return usersRepository.findByUsername(username);
    }
}
