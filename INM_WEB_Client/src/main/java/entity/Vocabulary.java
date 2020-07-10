package main.java.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.clients.VocabularyClient;

import java.io.IOException;

public class Vocabulary {
    private String categories;
    private String departments;
    private String users;

    public Vocabulary() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        VocabularyClient vbc = new VocabularyClient();
        Category[] categoriesJson = objectMapper.readValue(vbc.getSource("category"), Category[].class);
        Department[] departmentsJson = objectMapper.readValue(vbc.getSource("department"), Department[].class);
        Users[] usersJson = objectMapper.readValue(vbc.getSource("users"), Users[].class);

        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : categoriesJson) {
            stringBuilder.append("<option ").append("value=\"").append(category.getId()).append("\">").append(category.getTitle()).append("</option>");
        }
        categories = stringBuilder.toString();

        stringBuilder = new StringBuilder();
        for (Department department : departmentsJson) {
            stringBuilder.append("<option ").append("value=\"").append(department.getId()).append("\">").append(department.getTitle()).append("</option>");
        }
        departments = stringBuilder.toString();

        stringBuilder = new StringBuilder();
        for (Users users : usersJson) {
            stringBuilder.append("<option ").append("value=\"").append(users.getId()).append("\">").append(users.getName()).append("</option>");
        }
        users = stringBuilder.toString();
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }
}
