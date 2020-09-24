//package ru.kpp.incidentmanager.clients;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.ResourceAccessException;
//import org.springframework.web.client.RestTemplate;
//import ru.kpp.inm_client.entity.Incident;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//
///**
// * В данном классе реализован RESTful клиент, выполняющий HTTP-запросы к серверу приложения для
// * создания, чтения, обновления и удаления (CRUD) записей об инцидентах в базе данных
// */
//
//@Component
//public class IncidentClient {
//
//    /**
//     * Адрес RESTful API сервера приложения
//     */
//
//    private static final String BASE_URI = "http://localhost:8080/inm/incident";
//
//    /**
//     * Объявление класса, реализующего API методы взаимодействия по HTTP
//     */
//
//    final RestTemplate restTemplate = new RestTemplate();
//
//    public IncidentClient() throws ResourceAccessException {
//    }
//
//    /**
//     * Метод добавления записи об инциденте в базу данных
//     *
//     * @param nIncident экземпляр класса {@link Incident}
//     * @return экземпляр класса {@link Incident} с присвоенными автогенерируемыми полями
//     */
//
//    public Incident addIncident(Incident nIncident) {
//        HttpEntity<Incident> requestBody = new HttpEntity<>(nIncident);
//        return restTemplate.postForObject(BASE_URI, requestBody, Incident.class);
//    }
//
//    /**
//     * Метод получения записи об инциденте из базы данных по номеру инцидента
//     *
//     * @param id идентификационный номер записи об инциденте в базе данных
//     * @return экземпляр класса {@link Incident}
//     */
//
//    public Incident getIncident(int id) {
//        return restTemplate.getForObject(BASE_URI + "/" + id, Incident.class);
//    }
//
//    /**
//     * Метод получения списка всех записей об инцидентах содержащихся в базе данных
//     *
//     * @return массив экземпляров класса {@link Incident}
//     */
//
//    public List<Incident> getIncidents() {
//        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(BASE_URI + "/all", Incident[].class)));
//    }
//
//    /**
//     * Метод обновления записи об инциденте в базе данных по номеру инцидента
//     *
//     * @param nIncident экземпляр класса {@link Incident}
//     * @return обновленный экземпляр класса {@link Incident}
//     */
//
//    public Incident updateIncident(Incident nIncident) {
//        HttpEntity<Incident> requestBody = new HttpEntity<>(nIncident);
//        restTemplate.put(BASE_URI, requestBody, new Incident());
//        return restTemplate.getForObject(BASE_URI + "/" + nIncident.getId(), Incident.class);
//    }
//
//    /**
//     * Метод удаления записи об инциденте в базе данных
//     *
//     * @param id идентификационный номер записи об инциденте
//     */
//
//    public void deleteIncident(int id) {
//        restTemplate.delete(BASE_URI + "/" + id);
//    }
//
//
//}
