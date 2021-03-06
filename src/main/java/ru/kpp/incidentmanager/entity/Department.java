package ru.kpp.incidentmanager.entity;

import javax.persistence.*;
import java.util.Objects;


/**
 * Класс сущности, содержащий сведения об отделах и подразделениях, являющихся инициаторами заявки об инциденте,
 * в настоящем клиенте используется в классе {@link ru.kpp.incidentmanager.entity.Incident Incident},
 * а также для формирования справочников используемых в веб-формах
 */

@Entity
@Table(schema = "inm")
public class Department {
    private int id;
    private String title;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
