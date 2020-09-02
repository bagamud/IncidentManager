package ru.kpp.inm_client.clients;

import org.springframework.web.client.RestTemplate;
import ru.kpp.inm_client.entity.*;
import ru.kpp.inm_client.entity.Department;
import ru.kpp.inm_client.entity.Priority;

public class VocabularyClient {
    /*
     TODO:
     */
    private static final String BASE_URI = "http://localhost:8080/vocabulary/";

    RestTemplate restTemplate = new RestTemplate();

    Category[] categories = restTemplate.getForObject(BASE_URI + "categories", Category[].class);
    Department[] departments = restTemplate.getForObject(BASE_URI + "departments", Department[].class);
    Priority[] priority = restTemplate.getForObject(BASE_URI + "priority", Priority[].class);
    Status[] status = restTemplate.getForObject(BASE_URI + "status", Status[].class);
    Users[] users = restTemplate.getForObject(BASE_URI + "users", Users[].class);

    public String getCategorySelect() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : categories) {
            stringBuilder.append("<option ").append("value=\"").append(category.getId()).append("\">").append(category.getTitle()).append("</option>");
        }
        return stringBuilder.toString();
    }

    public String getDepartmentSelect() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Department department : departments) {
            stringBuilder.append("<option ").append("value=\"").append(department.getId()).append("\">").append(department.getTitle()).append("</option>");
        }
        return stringBuilder.toString();
    }

    public String getUserSelect() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Users users : users) {
            stringBuilder.append("<option ").append("value=\"").append(users.getId()).append("\">").append(users.getName()).append("</option>");
        }
        return stringBuilder.toString();
    }

    public String getStatusSelect() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Status status : status) {
            stringBuilder.append("<option ").append("value=\"").append(status.getId()).append("\">").append(status.getTitle()).append("</option>");
        }
        return stringBuilder.toString();
    }

}
