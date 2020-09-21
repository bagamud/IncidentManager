package ru.kpp.incidentmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.kpp.incidentmanager.entity.Incident;
import ru.kpp.incidentmanager.repositories.IncidentRepository;

import java.util.NoSuchElementException;

/**
 * Класс отвечающий за основное взаимодействие с записями об инцидентах, построенные по принципу RESTful
 * веб-службы CRUD (Create, Read, Update, Delete). Внешнее взаимодействие организовано в формате JSON.
 *
 * @author Ponkratov K.
 */

@RestController
@RequestMapping(path = "/incident")
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

    @PostMapping
    public Incident addIncident(@RequestBody Incident incident) {
        return incidentRepository.save(incident);
    }

    /**
     * Веб-метод получения записи об инциденте из базы данных по ID номеру записи
     *
     * @param id - номер запрашиваемой записи
     * @return - возвращается экземпляр класса Incident
     */

    @GetMapping(path = "/{id}")
    public Incident getIncident(@PathVariable int id) {
        try {
            return incidentRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid incident number", e);
        }
    }

    /**
     * Веб-метод получения всех записей об инцидентах из базы данных
     *
     * @return - возвращается массив экземпляров класса Incident
     */

    @GetMapping(path = "/all")
    public Iterable<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }


    /**
     * Веб-метод обновления записи об инциденте в базе данных
     *
     * @param incident - экземпляр класса Incident в формате JSON передаваемый для обновления
     * @param id       - номер обновляемой записи
     */

    @PutMapping(path = "/{id}")
    public Incident updateIncident(@RequestBody Incident incident, @PathVariable int id) {
        return incidentRepository.findById(id).map(incidentById -> {
            incident.setId(incidentById.getId());
            incidentById = incident;
            return incidentRepository.save(incidentById);
        }).orElseThrow();
    }

    /**
     * Веб-метод удаления записи об инциденте в базе даннх
     *
     * @param id номер записи об инциденте для удаления
     */

    @DeleteMapping(path = "/{id}")
    public void deleteIncident(@PathVariable int id) {
        incidentRepository.deleteById(id);
    }

}
