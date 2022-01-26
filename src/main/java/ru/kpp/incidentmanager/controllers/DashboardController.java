package ru.kpp.incidentmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpp.incidentmanager.entity.Users;
import ru.kpp.incidentmanager.repositories.IncidentRepository;
import ru.kpp.incidentmanager.repositories.UsersRepository;
import ru.kpp.incidentmanager.services.DictionariesService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    final DictionariesService dictionariesService;
    final IncidentRepository incidentRepository;
    final UsersRepository usersRepository;

    public DashboardController(DictionariesService dictionariesService,
                               IncidentRepository incidentRepository,
                               UsersRepository usersRepository) {
        this.dictionariesService = dictionariesService;
        this.incidentRepository = incidentRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping()
    public String dashboard(@RequestParam(defaultValue = "inservice") String status, Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);
        dictionariesService.connect(model);
        model.addAttribute("hidden", "hidden");
        switch (status) {
            case "inservice":
                model.addAttribute("incidents", incidentRepository.findAllByStatus_DoneOrderById(false));
                model.addAttribute("switchfilter", "all");
                break;
            case "all":
                model.addAttribute("incidents", incidentRepository.findAllByOrderById());
                model.addAttribute("switchfilter", "inservice");
                break;
        }
        return "dashboard";
    }
}