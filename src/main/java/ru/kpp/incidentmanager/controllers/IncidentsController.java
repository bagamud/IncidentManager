package ru.kpp.incidentmanager.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kpp.incidentmanager.entity.Incident;
import ru.kpp.incidentmanager.entity.Status;
import ru.kpp.incidentmanager.repositories.IncidentRepository;

/**
 * Класс отвечающий за основное взаимодействие с записями об инцидентах, построенные по принципу RESTful
 * веб-службы CRUD (Create, Read, Update, Delete). Внешнее взаимодействие организовано в формате JSON.
 *
 * @author Ponkratov K.
 */

@RestController
public class IncidentsController {

    final
    IncidentRepository incidentRepository;


    public IncidentsController(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    /**
     * Веб-метод добавления записи об инцидентев базу данных
     *
     * @param incident - передается экземпляр класса Incident для добавления в базу данных
     * @return экземпляр класса Incident, записанный в базу данных
     */

    public Incident addIncident(@RequestBody Incident incident) {
        return incidentRepository.save(incident);
    }

    /**
     * Веб-метод получения записи об инциденте из базы данных по ID номеру записи
     *
     * @param id - номер запрашиваемой записи
     * @return - возвращается экземпляр класса Incident
     */

    public Incident getIncident(int id) {
        return incidentRepository.findById(id);
    }

    /**
     * Веб-метод обновления записи об инциденте в базе данных
     *
     * @param incident - экземпляр класса Incident в формате JSON передаваемый для обновления
     * @param id       - номер обновляемой записи
     */

    public Incident updateIncident(Incident incident, int id) {
        Incident incidentById = incidentRepository.findById(id);
        incidentById = incident;
        return incidentRepository.save(incidentById);
    }

    /**
     * Веб-метод получения всех записей об инцидентах из базы данных со статусом, отличным от статуса "Решен"
     *
     * @return - возвращает коллекцию экземпляров класса Incident
     */

    public String getIncidentsInService(Status status) {
        StringBuilder stringBuilder = new StringBuilder();
        String alert;
        String userName;
        for (Incident incident : incidentRepository.findAllByStatusIsNot(status)) {
            if (incident.getEngineer() == null) {
                userName = "Заявка не назначена";
            } else userName = incident.getEngineer().getName();
            if (incident.getPriority().getId() == 1) {
                alert = " class=\"table-danger\"";
            } else if (incident.getPriority().getId() == 2) {
                alert = " class=\"table-warning\"";
            } else alert = "";
            stringBuilder.append("<tr onclick=\"location.href='/manager/get?id=")
                    .append(incident.getId())
                    .append("'\"")
                    .append(alert).append("><td>")
                    .append(incident.getId())
                    .append("</td><td>")
                    .append(incident.getRequesterdepartment().getTitle())
                    .append("</td><td>")
                    .append(incident.getOpendate())
                    .append("</td><td>")
                    .append(userName)
                    .append("</td><td>")
                    .append(incident.getPriority().getDescription())
                    .append("</td><td>")
                    .append(incident.getCategory().getTitle())
                    .append("</td><td>")
                    .append(incident.getStatus().getTitle())
                    .append("</td></tr>");
        }
        return stringBuilder.toString();
    }

}
