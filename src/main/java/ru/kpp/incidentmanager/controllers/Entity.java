package ru.kpp.incidentmanager.controllers;

import org.springframework.web.bind.annotation.*;
import ru.kpp.incidentmanager.entity.Incident;
import ru.kpp.incidentmanager.repositories.IncidentRepository;

/**
 * Веб-методы реализующие основное взаимодействие с записями об инцидентах, построенные по принципу RESTful
 * веб-службы CRUD (Create, Read, Update, Delete). Внешнее взаимодействие организовано в формате JSON.
 *
 * @author Ponkratov K.
 */
@RestController
@RequestMapping(path = "/manager")
public class Entity {

    /*
    TODO: Logger в каждом методе с записью в поле Journal INM.INCIDENT
     */

    final
    IncidentRepository incidentRepository;

    public Entity(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    /**
     * Веб-метод добавления записи об инцидентев базу данных
     *
     * @param incident - запись инцидента добавляемая в базу данных
     */

    @PostMapping(path = "/add")
    public Incident addIncident(@RequestBody Incident incident) {
        return incidentRepository.save(incident);
    }

    /**
     * Веб-метод получения записи об инциденте из базы данных по ID номеру записи
     *
     * @param id - номер запрашиваемой записи
     * @return - возвращается экземпляр класса Incident в формате JSON
     */

    @GetMapping
    public Incident getIncident(@RequestParam int id) {
        return incidentRepository.findById(id).orElseThrow();
    }

    /**
     * Веб-метод получения всех записей об инцидентах из базы данных
     *
     * @return - возвращается массив записей об инцидентах в формате JSON
     */

    @GetMapping(path = "/all")
    public Iterable<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    /**
     * Веб-метод получения всех записей об инцидентах из базы данных со статусом, отличным от статуса "Решен"
     *
     * @return - возвращает коллекцию экземпляров класса Incident
     */
    @GetMapping(path = "/service")
    public Iterable<Incident> getIncidentsInWork() {
        return incidentRepository.findByStatusNotLike(3);
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

}
