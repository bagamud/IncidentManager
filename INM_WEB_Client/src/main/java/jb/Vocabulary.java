package main.java.jb;


import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.clients.VocabularyClient;
import main.java.entity.*;

import java.io.IOException;

public class Vocabulary {
    private Category[] categories;
    private Department[] departments;
    private IncStatus[] status;
    private Priority[] priority;
    private Users[] users;

    public Vocabulary() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        VocabularyClient vbc = new VocabularyClient();
        categories = objectMapper.readValue(vbc.getSource("category"), Category[].class);
        departments = objectMapper.readValue(vbc.getSource("department"), Department[].class);
        users = objectMapper.readValue(vbc.getSource("users"), Users[].class);
        status = objectMapper.readValue(vbc.getSource("status"), IncStatus[].class);
        priority = objectMapper.readValue(vbc.getSource("priority"), Priority[].class);

    }

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
        for (IncStatus status : status) {
            stringBuilder.append("<option ").append("value=\"").append(status.getId()).append("\">").append(status.getTitle()).append("</option>");
        }
        return stringBuilder.toString();
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public Users[] getUsers() {
        return users;
    }

    public void setUsers(Users[] users) {
        this.users = users;
    }

    public IncStatus[] getStatus() {
        return status;
    }

    public void setStatus(IncStatus[] status) {
        this.status = status;
    }

    public Priority[] getPriority() {
        return priority;
    }

    public void setPriority(Priority[] priority) {
        this.priority = priority;
    }
}
