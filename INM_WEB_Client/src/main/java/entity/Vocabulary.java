package main.java.entity;

import java.util.ArrayList;
import java.util.List;

public class Vocabulary {
    private List<Category> categories;
    private List<Department> departments;
    private List<Users> users;

    public Vocabulary() {
        categories = new ArrayList<>();
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
