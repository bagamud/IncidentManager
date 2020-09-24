//package ru.kpp.incidentmanager.clients;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import ru.kpp.inm_client.entity.*;
//
///**
// * В данном классе реализован клиент, выполняющий HTTP-запросы к серверу приложения для формирования на стороне клиента
// * справочников сущностей, содержащихся в базе данных и используемых для веб-формы клиентского приложения
// */
//
//@Component
//public class EntityClient {
//
//    /**
//     * Адрес RESTful API сервера приложения
//     */
//
//    private static final String BASE_URI = "http://localhost:8080/inm/";
//
//    /**
//     * Объявление класса, реализующего API методы взаимодействия по HTTP
//     */
//
//    final RestTemplate restTemplate = new RestTemplate();
//
//    /**
//     * Объявление массивов классов сущностей
//     */
//
//    final Category[] categories = restTemplate.getForObject(BASE_URI + "vocabulary/category", Category[].class);
//    final Department[] departments = restTemplate.getForObject(BASE_URI + "vocabulary/department", Department[].class);
//    final Priority[] priority = restTemplate.getForObject(BASE_URI + "vocabulary/priority", Priority[].class);
//    final Status[] status = restTemplate.getForObject(BASE_URI + "vocabulary/status", Status[].class);
//    final Users[] users = restTemplate.getForObject(BASE_URI + "vocabulary/users", Users[].class);
//    final Incident[] incidents = restTemplate.getForObject(BASE_URI + "vocabulary/inservice", Incident[].class);
//
//    public EntityClient() {
//    }
//
//    /**
//     * Справочник категорий инцидента.
//     * В настоящем клиенте используется для элементов списка значений формы (manager.jsp)
//     *
//     * @return массив экземпляров класса {@link Category}
//     */
//
//    public Category[] getCategories() {
//        return categories;
//    }
//
//    /**
//     * Справочник отделов и подразделениях, инициирующих заявки об инциденте
//     * В настоящем клиенте используется для элементов списка значений формы (manager.jsp)
//     *
//     * @return массив экземпляров класс {@link Department}
//     */
//
//    public Department[] getDepartments() {
//        return departments;
//    }
//
//    /**
//     * Справочник значений приоритета исполнения заявок об инцидентах
//     * В настоящем клиенте используется для элементов списка значений формы (manager.jsp)
//     *
//     * @return массив экземпляров класса {@link Priority}
//     */
//
//    public Priority[] getPriority() {
//        return priority;
//    }
//
//    /**
//     * Справочник статусов заявки об инциденте
//     * В настоящем клиенте используется для элементов списка значений формы (manager.jsp)
//     *
//     * @return массив экземпляров класса {@link Status}
//     */
//
//    public Status[] getStatus() {
//        return status;
//    }
//
//    /**
//     * Справочник зарегистрированных пользователей
//     * В настоящем клиенте используется для элементов списка значений формы (manager.jsp)
//     *
//     * @return массив экземпляра класса {@link Users}
//     */
//
//    public Users[] getUsers() {
//        return users;
//    }
//
//    /**
//     * Метод поиска пользователя по username из справочника пользователей полученных ранее.
//     * В настоящем клиенте используется для формирования записи о пользователе UsersService,
//     * используемой для аутентификации объектов
//     *
//     * @param username строковое значение имени пользователя
//     * @return экземпляр класса {@link Users}
//     */
//
//    public Users findByUsername(String username) {
//        assert users != null;
//        Users userByUsername = new Users();
//        for (Users user : users) {
//            if (user.getUsername().equals(username)) userByUsername = user;
//        }
//        return userByUsername;
//    }
//
//    /**
//     * Метод получения списка записей об инцидентах, имеющих статус не равный статусу "Решен".
//     * В настоящем клиенте используется для формирования списка нерешенных инцидентов для формы (dashboard.jsp).
//     *
//     * @return массив экземпляров класса {@link Incident}
//     */
//
//    public Incident[] getIncidentsInService() {
//        return incidents;
//    }
//}
