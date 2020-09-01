package ru.kpp.incidentmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpp.incidentmanager.entity.*;
import ru.kpp.incidentmanager.repositories.*;

@Controller
@RequestMapping(path = "/vocabulary")
public class Vocabulary {

    /**
     * Веб-метод отвечающий за загрузку справочников для отображения на сайте
     */

    final CategoryRepository categoryRepository;
    final DepartmentRepository departmentRepository;
    final PriorityRepository priorityRepository;
    final StatusRepository statusRepository;
    final UsersRepository usersRepository;

    public Vocabulary(CategoryRepository categoryRepository, DepartmentRepository departmentRepository,
                      PriorityRepository priorityRepository, StatusRepository statusRepository,
                      UsersRepository usersRepository) {
        this.categoryRepository = categoryRepository;
        this.departmentRepository = departmentRepository;
        this.priorityRepository = priorityRepository;
        this.statusRepository = statusRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping(path = "/category")
    public @ResponseBody
    Iterable<Category> getCategories() {

        return categoryRepository.findAll();
    }

    @GetMapping(path = "/department")
    public @ResponseBody
    Iterable<Department> getDepartments() {

        return departmentRepository.findAll();
    }

    @GetMapping(path = "/priority")
    public @ResponseBody
    Iterable<Priority> getPriorities() {

        return priorityRepository.findAll();
    }

    @GetMapping(path = "/status")
    public @ResponseBody
    Iterable<Status> getStatus() {

        return statusRepository.findAll();
    }

    @GetMapping(path = "/users")
    public @ResponseBody
    Iterable<Users> getUsers() {

        return usersRepository.findAll();
    }
}
