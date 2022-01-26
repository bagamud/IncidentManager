package ru.kpp.incidentmanager.services;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import ru.kpp.incidentmanager.repositories.*;

@Component
public class DictionariesService {
    final DepartmentRepository departmentRepository;
    final CategoryRepository categoryRepository;
    final PriorityRepository priorityRepository;
    final StatusRepository statusRepository;
    final UsersRepository usersRepository;

    public DictionariesService(DepartmentRepository departmentRepository,
                               CategoryRepository categoryRepository,
                               PriorityRepository priorityRepository,
                               StatusRepository statusRepository,
                               UsersRepository usersRepository) {
        this.departmentRepository = departmentRepository;
        this.categoryRepository = categoryRepository;
        this.priorityRepository = priorityRepository;
        this.statusRepository = statusRepository;
        this.usersRepository = usersRepository;
    }

    public void connect(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("priority", priorityRepository.findAll());
        model.addAttribute("status", statusRepository.findAll());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("users", usersRepository.findAll());
    }

    public DepartmentRepository getDepartmentRepository() {
        return departmentRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }


    public PriorityRepository getPriorityRepository() {
        return priorityRepository;
    }

    public StatusRepository getStatusRepository() {
        return statusRepository;
    }

    public UsersRepository getUsersRepository() {
        return usersRepository;
    }
}
