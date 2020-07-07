package main.java.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.clients.VocabularyClient;

import java.util.ArrayList;
import java.util.List;

public class Vocabulary {
    private List<Category> categories;
    private List<Department> departments;
    private List<Users> users;

    public Vocabulary() {
        ObjectMapper objectMapper = new ObjectMapper();
        VocabularyClient vbc = new VocabularyClient();
//        categories = objectMapper.readValue(vbc.getCategory(), Category.class);
        departments = new ArrayList<>();
        users = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
