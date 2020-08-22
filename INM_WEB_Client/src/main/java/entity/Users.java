package main.java.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonAutoDetect
public class Users {
    @JsonProperty
    private int id;
    @JsonProperty
    private String login;
    @JsonProperty
    private String name;
    @JsonProperty
    private int userGroup;
    @JsonProperty
    private String contacts;
    @JsonProperty
    private String email;

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(int userGroup) {
        this.userGroup = userGroup;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

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
                userGroup == users.userGroup &&
                Objects.equals(login, users.login) &&
                Objects.equals(name, users.name) &&
                Objects.equals(contacts, users.contacts) &&
                Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, name, userGroup, contacts, email);
    }
}
