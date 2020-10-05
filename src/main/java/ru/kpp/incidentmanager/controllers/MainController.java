package ru.kpp.incidentmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpp.incidentmanager.entity.*;
import ru.kpp.incidentmanager.form.IncidentForm;
import ru.kpp.incidentmanager.form.IncidentTransForm;
import ru.kpp.incidentmanager.repositories.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * В данном классе реализованы методы взаимодействия с сущностями проекта для взаимодействия с веб-формами интерфейса
 */

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
    final FaqController faqController;


    public MainController(CategoryRepository categoryRepository, DepartmentRepository departmentRepository,
                          PriorityRepository priorityRepository, StatusRepository statusRepository,
                          UsersRepository usersRepository, IncidentRepository incidentRepository,
                          IncidentsController incidentsController, IncidentTransForm incidentTransForm,
                          FaqController faqController) {
        this.categoryRepository = categoryRepository;
        this.departmentRepository = departmentRepository;
        this.priorityRepository = priorityRepository;
        this.statusRepository = statusRepository;
        this.usersRepository = usersRepository;
        this.incidentRepository = incidentRepository;

        this.incidentsController = incidentsController;
        this.incidentTransForm = incidentTransForm;
        this.faqController = faqController;
    }

    /**
     * Метод контроллера страницы manager, в котором реализовано получение справочников
     * в виде массивов классов сущностей для работы с записью об инциденте, и передача
     * справочников в аттрибуты страницы
     *
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @GetMapping(path = "/manager")
    public String manager(Model model) {
        getVocabulary(model);
        return "manager";
    }

    /**
     * Метод контроллера реализующие получение справочников и записи об инциденте
     * по идентификационному номеру и дальнейшая передача в аттрибуты страницы
     *
     * @param id    идентификационный номер записи об инциденте
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @GetMapping(path = "/manager/get")
    public String getIncident(@RequestParam int id, Model model) {
        getVocabulary(model);
        try {
            Incident incident = incidentsController.getIncident(id);

            IncidentForm incidentForm = incidentTransForm.convert(incident);
            model.addAttribute("incident", incidentForm);

        } catch (NumberFormatException | NullPointerException error) {

            model.addAttribute("error", error.getMessage());
        }
        return "manager";
    }

    /**
     * Метод контроллера реализующий добавление записи об инциденте из веб-формы
     * в базу данных, возвращает сформированную запись из базы данных и записывает
     * в аттрибуты для отображения в веб-форме
     *
     * @param incidentForm сведения об инциденте переданные с веб-формы
     * @param model        интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @PostMapping(path = "/manager/add")
    public String addIncident(IncidentForm incidentForm, BindingResult bindingResult, Model model) {
        getVocabulary(model);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
        }
        try {
            if (incidentForm.getOpendate() == null) incidentForm.setOpendate(new Timestamp(new Date().getTime()));
            if (incidentForm.getPriority() == 0) incidentForm.setPriority(3);
            if (incidentForm.getStatus() == 0) incidentForm.setStatus(1);
            Incident incident = incidentTransForm.convert(incidentForm);
            model.addAttribute(
                    "incident",
                    incidentTransForm.convert(incidentsController.addIncident(incident))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "manager";
    }

    /**
     * Метод контроллера реализующий обновление в баз данных статуса записи об инциденте
     * на "Решен" и формирование даты решения заявки, возвращает обновленную
     * запись из базы данных и записывает в аттрибуты для отображения в веб-форме
     *
     * @param id    идентификатор записи об инциденте
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @PostMapping(path = "/manager/done")
    public String fixIncident(@RequestParam int id, Model model) {
        getVocabulary(model);

        Incident incident = incidentRepository.findById(id);
        incident.setStatus(new Status(3, "Решен"));
        if (incident.getClosedate() == null) incident.setClosedate(new Timestamp(new Date().getTime()));

        model.addAttribute(
                "incident",
                incidentTransForm.convert(incidentsController.updateIncident(incident, id))
        );
        return "manager";
    }

    /**
     * Метод контроллера страницы dashboard, в котором реализовано получение записей об инциденте,
     * имеющих статус отличающийся от статуса "Решен", и их передача в аттрибуты страницы
     *
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @GetMapping(path = "/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("user", usersRepository.findAll());
        model.addAttribute(
                "incidentsInService",
                incidentsController.getIncidentsInService((statusRepository.findAll()).get(2))
        );
        return "dashboard";
    }

    /**
     * Локальный метод формирования аттрибутов справочников
     *
     * @param model интерфейс определяющий аттрибуты
     */

    private void getVocabulary(Model model) {
        StringBuilder sb = new StringBuilder();
        for (Category category : categoryRepository.findAll()) {
            sb.append("<option value=\"")
                    .append(category.getId())
                    .append("\">")
                    .append(category.getTitle())
                    .append("</option>");
        }
        String categories = sb.toString();
        model.addAttribute("categories", categories);

        sb = new StringBuilder();
        for (Department department : departmentRepository.findAll()) {
            sb.append("<option value=\"")
                    .append(department.getId())
                    .append("\">")
                    .append(department.getTitle())
                    .append("</option>");
        }
        String departments = sb.toString();
        model.addAttribute("departments", departments);


        sb = new StringBuilder();
        for (Priority priority : priorityRepository.findAll()) {
            sb.append("<option value=\"")
                    .append(priority.getId())
                    .append("\">")
                    .append(priority.getDescription())
                    .append("</option>");
        }
        String priority = sb.toString();
        model.addAttribute("priority", priority);

        sb = new StringBuilder();
        for (Status status : statusRepository.findAll()) {
            sb.append("<option value=\"")
                    .append(status.getId())
                    .append("\">")
                    .append(status.getTitle())
                    .append("</option>");
        }
        String status = sb.toString();
        model.addAttribute("status", status);

        sb = new StringBuilder();
        for (Users users : usersRepository.findAll()) {
            sb.append("<option value=\"")
                    .append(users.getId())
                    .append("\">")
                    .append(users.getName())
                    .append("</option>");
        }
        String users = sb.toString();
        model.addAttribute("users", users);

        model.addAttribute("user", usersRepository.findAll());

        model.addAttribute("faq", faqController.getFaq());
    }

}
