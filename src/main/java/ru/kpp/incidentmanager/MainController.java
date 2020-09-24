package ru.kpp.incidentmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpp.incidentmanager.controllers.IncidentsController;
import ru.kpp.incidentmanager.controllers.VocabularyController;
import ru.kpp.incidentmanager.entity.Incident;
import ru.kpp.incidentmanager.form.IncidentForm;
import ru.kpp.incidentmanager.form.IncidentTransForm;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

@Controller
public class MainController {

    final VocabularyController vocabularyController;
    final IncidentsController incidentsController;
    final IncidentTransForm incidentTransForm;

    public MainController(VocabularyController vocabularyController, IncidentsController incidentsController,
                          IncidentTransForm incidentTransForm) {
        this.vocabularyController = vocabularyController;
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
        model.addAttribute("incidentsInService", vocabularyController.getIncidentsInService());
        return "dashboard";
    }

    private void getVocabulary(Model model) {
        model.addAttribute("categories", vocabularyController.getCategories());
        model.addAttribute("departments", vocabularyController.getDepartments());
        model.addAttribute("priority", vocabularyController.getPriorities());
        model.addAttribute("status", vocabularyController.getStatus());
        model.addAttribute("users", vocabularyController.getUsers());
    }
}
