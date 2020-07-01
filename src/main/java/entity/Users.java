package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Users {
    private int id;
    private String login;
    private String password;
    private String name;
    private Integer userGroup;
    private String contacts;
    private String email;
    private Collection<Incident> incidentsById;
    private Collection<Incident> incidentsById_0;
    private UsersGroup usersGroupByUserGroup;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
    @Column(name = "USER_GROUP")
    public Integer getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Integer userGroup) {
        this.userGroup = userGroup;
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
                Objects.equals(login, users.login) &&
                Objects.equals(password, users.password) &&
                Objects.equals(name, users.name) &&
                Objects.equals(userGroup, users.userGroup) &&
                Objects.equals(contacts, users.contacts) &&
                Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, userGroup, contacts, email);
    }

    @OneToMany(mappedBy = "usersByEngineer")
    public Collection<Incident> getIncidentsById() {
        return incidentsById;
    }

    public void setIncidentsById(Collection<Incident> incidentsById) {
        this.incidentsById = incidentsById;
    }

    @OneToMany(mappedBy = "usersByOperator")
    public Collection<Incident> getIncidentsById_0() {
        return incidentsById_0;
    }

    public void setIncidentsById_0(Collection<Incident> incidentsById_0) {
        this.incidentsById_0 = incidentsById_0;
    }

    @ManyToOne
    @JoinColumn(name = "USER_GROUP", referencedColumnName = "ID")
    public UsersGroup getUsersGroupByUserGroup() {
        return usersGroupByUserGroup;
    }

    public void setUsersGroupByUserGroup(UsersGroup usersGroupByUserGroup) {
        this.usersGroupByUserGroup = usersGroupByUserGroup;
    }
}