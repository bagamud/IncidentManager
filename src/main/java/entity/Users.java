package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "USERS")
public class Users {
    private int id;
    private String login;
    private String password;
    private String name;
    private int userGroup;
    private String contacts;
    private String email;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LOGIN", nullable = false, length = 255)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "USER_GROUP", nullable = false)
    public int getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(int userGroup) {
        this.userGroup = userGroup;
    }

    @Basic
    @Column(name = "CONTACTS", nullable = true, length = 255)
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 255)
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
                Objects.equals(password, users.password) &&
                Objects.equals(name, users.name) &&
                Objects.equals(contacts, users.contacts) &&
                Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, userGroup, contacts, email);
    }
}
