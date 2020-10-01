package ru.kpp.incidentmanager.entity;

import javax.persistence.*;
import java.util.Objects;


/**
 * Класс сущности ролей пользователей, используется
 * при формировании сведений о пользователе используемых при аутентификации доступа пользователя
 * к ресурсам
 */

@Entity
@Table(schema = "inm")
public class Roles {
    private int id;
    private String name;

    @Id
    @Column
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles that = (Roles) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
