package ru.kpp.incidentmanager.controllers;

import org.springframework.web.bind.annotation.*;
import ru.kpp.incidentmanager.entity.Users;
import ru.kpp.incidentmanager.repositories.UsersRepository;

/**
 * Класс отвечающий за получение записи о зарегистрированных пользователях
 */

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Веб-метод получения записи о пользоваетел по имени пользователя
     *
     * @param username - запрашиваемое имя пользователя
     * @return - возвращает экземпляр класса Users в формате JSON
     */

    @GetMapping(path = "/{username}")
    public @ResponseBody
    Users getUser(@PathVariable String username) {
        return usersRepository.findByUsername(username);
    }
}
