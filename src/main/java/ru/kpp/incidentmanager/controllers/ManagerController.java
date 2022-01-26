package ru.kpp.incidentmanager.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpp.incidentmanager.entity.Incident;
import ru.kpp.incidentmanager.entity.Status;
import ru.kpp.incidentmanager.entity.Users;
import ru.kpp.incidentmanager.repositories.FaqRepository;
import ru.kpp.incidentmanager.repositories.IncidentRepository;
import ru.kpp.incidentmanager.repositories.UsersRepository;
import ru.kpp.incidentmanager.services.DictionariesService;

import java.sql.Timestamp;
import java.util.Date;

/**
 * В данном классе реализованы методы взаимодействия с сущностями проекта для взаимодействия с веб-формами интерфейса
 */

@Controller
@RequestMapping("/manager")
public class ManagerController {

    final DictionariesService dictionariesService;
    final UsersRepository usersRepository;
    final IncidentRepository incidentRepository;
    final FaqRepository faqRepository;


    public ManagerController(DictionariesService dictionariesService,
                             UsersRepository usersRepository,
                             IncidentRepository incidentRepository,
                             FaqRepository faqRepository) {
        this.dictionariesService = dictionariesService;
        this.usersRepository = usersRepository;
        this.incidentRepository = incidentRepository;
        this.faqRepository = faqRepository;
    }

    /**
     * Метод контроллера страницы manager, в котором реализовано получение справочников
     * в виде массивов классов сущностей для работы с записью об инциденте, и передача
     * справочников в аттрибуты страницы
     *
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @GetMapping(path = "")
    public String manager(Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);
        dictionariesService.connect(model);
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

    @GetMapping(path = "/get")
    public String getIncident(@RequestParam int id, Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);
        dictionariesService.connect(model);
        model.addAttribute("faq", faqRepository.findAll());

        try {
            model.addAttribute("incident", incidentRepository.findById(id));
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
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @PostMapping(path = "/add")
    public String addIncident(Incident incident, BindingResult bindingResult, Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);
        dictionariesService.connect(model);
        model.addAttribute("faq", faqRepository.findAll());
        if (incident.getOpendate() == null) {
            incident.setOpendate(new Timestamp(new Date().getTime()));
        }
        if (incident.getPriority() == null) {
            incident.setPriority(dictionariesService.getPriorityRepository().findById(3));
        }
        if (incident.getStatus() == null) {
            incident.setStatus(dictionariesService.getStatusRepository().findById(1));
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
        }

        try {
            model.addAttribute("incident", incidentRepository.save(incident));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "manager";
    }
//
//    /**
//     * Метод контроллера реализующий обновление записи об инциденте из веб-формы в баз данных, возвращает обновленную
//     * запись из базы данных и записывает в аттрибуты для отображения в веб-форме
//     *
//     * @param incidentForm сведения об инциденте переданные с веб-формы
//     * @param id           идентификатор записи об инциденте
//     * @param model        интерфейс определяющий аттрибуты
//     * @return возвращяет путь к странице
//     */
//
//    @PostMapping(path = "/manager/upd")
//    public String updateIncident(/*@Valid*/ IncidentForm incidentForm, @RequestParam int id, Model model) throws ParseException {
//        getVocabulary(model);
//        Incident incident = incidentTransForm.convert(incidentForm);
//        model.addAttribute("incident", incidentTransForm.convert(incidentsController.updateIncident(incident, id)));
//        return "manager";
//    }
//

    /**
     * Метод контроллера реализующий обновление в баз данных статуса записи об инциденте
     * на "Решен" и формирование даты решения заявки, возвращает обновленную
     * запись из базы данных и записывает в аттрибуты для отображения в веб-форме
     *
     * @param id    идентификатор записи об инциденте
     * @param model интерфейс определяющий аттрибуты
     * @return возвращяет путь к странице
     */

    @PostMapping(path = "/done")
    public String fixIncident(@RequestParam int id, Model model) {
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersRepository.findByUsername(userAuth.getUsername());
        model.addAttribute("user", user);
        dictionariesService.connect(model);
        model.addAttribute("faq", faqRepository.findAll());


        Incident incident = incidentRepository.findById(id);
        incident.setStatus(new Status(3, "Решен"));
        if (incident.getClosedate() == null) incident.setClosedate(new Timestamp(new Date().getTime()));

        model.addAttribute("incident", incidentRepository.save(incident));
        return "manager";
    }
}
