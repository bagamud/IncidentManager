package ru.kpp.incidentmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Users {
    private int id;
    private String username;
    @JsonIgnore
    private String password;
    private String name;
    private int role;
    private String contacts;
    private String email;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "role")
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Basic
    @Column(name = "CONTACTS")
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                role == users.role &&
                Objects.equals(username, users.username) &&
                Objects.equals(password, users.password) &&
                Objects.equals(name, users.name) &&
                Objects.equals(contacts, users.contacts) &&
                Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, role, contacts, email);
    }
}
