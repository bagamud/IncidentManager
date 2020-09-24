package ru.kpp.incidentmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpp.incidentmanager.controllers.IncidentsController;
import ru.kpp.incidentmanager.entity.Incident;
import ru.kpp.incidentmanager.form.IncidentForm;
import ru.kpp.incidentmanager.form.IncidentTransForm;
import ru.kpp.incidentmanager.repositories.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

@Controller
public class MainController {

    final CategoryRepository categoryRepository;
    final DepartmentRepository departmentRepository;
    final PriorityRepository priorityRepository;
    final StatusRepository statusRepository;
    final UsersRepository usersRepository;
    final IncidentRepository incidentRepository;
    final IncidentsController incidentsController;
    final IncidentTransForm incidentTransForm;

    public MainController(CategoryRepository categoryRepository, DepartmentRepository departmentRepository,
                          PriorityRepository priorityRepository, StatusRepository statusRepository,
                          UsersRepository usersRepository, IncidentRepository incidentRepository, IncidentsController incidentsController,
                          IncidentTransForm incidentTransForm) {
        this.categoryRepository = categoryRepository;
        this.departmentRepository = departmentRepository;
        this.priorityRepository = priorityRepository;
        this.statusRepository = statusRepository;
        this.usersRepository = usersRepository;
        this.incidentRepository = incidentRepository;
        this.incidentsController = incidentsController;
        this.incidentTransForm = incidentTransForm;
    }

    @GetMapping(path = "/")
    public String index(Model model) {
        return "main";
    }

    @GetMapping(path = "/manager")
    public String manager(Model model) {
        getVocabulary(model);
        return "manager";
    }

    @GetMapping(path = "/manager/{id}")
    public String getIncident(@PathVariable(name = "id") int id, Model model) {
        getVocabulary(model);
        model.addAttribute("incident", incidentTransForm.convert(incidentsController.getIncident(id)));
        return "manager";
    }

    @GetMapping(path = "/manager/add")
    public String addIncident(@Valid IncidentForm incidentForm, /*BindingResult bindingResult,*/ Model model) throws ParseException {
        getVocabulary(model);
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getFieldErrors());
//        }
        Incident incident = incidentTransForm.convert(incidentForm);
        model.addAttribute("incidentF", incidentTransForm.convert(incidentsController.addIncident(incident)));
        return "manager";
    }

    @PutMapping(path = "/manager/{id}")
    public String updateIncident(@Valid @RequestBody IncidentForm incidentForm, @PathVariable int id, Model model) throws ParseException {
        getVocabulary(model);
        Incident incident = incidentTransForm.convert(incidentForm);
        model.addAttribute("incident", incidentTransForm.convert(incidentsController.updateIncident(incident, id)));
        return "manager";
    }

    @GetMapping(path = "/manager/done/{id}")
    public String fixIncident(@Valid IncidentForm incidentForm, @PathVariable int id, Model model) throws ParseException {
        getVocabulary(model);
        int influence = Integer.parseInt((String) Objects.requireNonNull(model.getAttribute("influence")));
        int urgency = Integer.parseInt((String) Objects.requireNonNull(model.getAttribute("urgency")));
        incidentForm.setPriority(urgency - 1 + influence);
        incidentForm.setStatus(3);
        incidentForm.setClosedate(new Timestamp(new Date().getTime()));
        Incident incident = incidentTransForm.convert(incidentForm);
        model.addAttribute("incident", incidentTransForm.convert(incidentsController.updateIncident(incident, id)));
        return "manager";
    }

    @GetMapping(path = "/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("incidentsInService", incidentsController.getIncidentsInService((statusRepository.findAll()).get(3)));
        return "dashboard";
    }

    private void getVocabulary(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("priority", priorityRepository.findAll());
        model.addAttribute("status", statusRepository.findAll());
        model.addAttribute("users", usersRepository.findAll());
    }
}
