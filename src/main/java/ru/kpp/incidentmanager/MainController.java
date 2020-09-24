package ru.kpp.incidentmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * Метод контроллера домашней страницы
     *
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице main
     */

    @GetMapping(path = "/")
    public String index(Model model) {
        return "main";
    }

    /**
     * Метод контроллера страницы manager, в котором реализовано получение справочников в виде массивов классов сущностей
     * для работы с записью об инциденте, и передача справочников в аттрибуты страницы
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
     * Метод контроллера реализующие получение справочников и записи об инциденте по идентификационному номеру
     * и дальнейшая передача в аттрибуты страницы
     *
     * @param id    идентификационный номер записи об инциденте
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */
    @GetMapping(path = "/manager/{id}")
    public String getIncident(@PathVariable int id, Model model) {
        getVocabulary(model);
        model.addAttribute("incident", incidentTransForm.convert(incidentsController.getIncident(id)));
        return "manager";
    }

    /**
     * Метод контроллера реализующий добавление записи об инциденте из веб-формы в базу данных, возвращает сформированную
     * запись из базы данных и записывает в аттрибуты для отображения в веб-форме
     *
     * @param incidentForm сведения об инциденте переданные с веб-формы
     * @param model        интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @GetMapping(path = "/manager/add")
    public String addIncident(@Valid IncidentForm incidentForm, /*BindingResult bindingResult,*/ Model model) {
        getVocabulary(model);
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getFieldErrors());
//        }
        Incident incident = incidentTransForm.convert(incidentForm);
        model.addAttribute("incident", incidentTransForm.convert(incidentsController.addIncident(incident)));
        return "manager";
    }

    /**
     * Метод контроллера реализующий обновление записи об инциденте из веб-формы в баз данных, возвращает обновленную
     * запись из базы данных и записывает в аттрибуты для отображения в веб-форме
     *
     * @param incidentForm сведения об инциденте переданные с веб-формы
     * @param id           идентификатор записи об инциденте
     * @param model        интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @PutMapping(path = "/manager/{id}")
    public String updateIncident(@Valid @RequestBody IncidentForm incidentForm, @PathVariable int id, Model model) {
        getVocabulary(model);
        Incident incident = incidentTransForm.convert(incidentForm);
        model.addAttribute("incident", incidentTransForm.convert(incidentsController.updateIncident(incident, id)));
        return "manager";
    }

    /**
     * Метод контроллера реализующий обновление в баз данных статуса записи об инциденте на "Решен" и формирование даты
     * решения заявки, возвращает обновленную
     * запись из базы данных и записывает в аттрибуты для отображения в веб-форме
     *
     * @param incidentForm сведения об инциденте переданные с веб-формы
     * @param id           идентификатор записи об инциденте
     * @param model        интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

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

    /**
     * Метод контроллера страницы dashboard, в котором реализовано получение записей об инциденте, имеющих статус отличающийся
     * от статуса "Решен", и их передача в аттрибуты страницы
     *
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @GetMapping(path = "/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("incidentsInService", incidentsController.getIncidentsInService((statusRepository.findAll()).get(3)));
        return "dashboard";
    }

    /**
     * Локальный метод формирования аттрибутов справочников
     *
     * @param model интерфейс определяющий аттрибуты
     */

    private void getVocabulary(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("priority", priorityRepository.findAll());
        model.addAttribute("status", statusRepository.findAll());
        model.addAttribute("users", usersRepository.findAll());
    }
}
