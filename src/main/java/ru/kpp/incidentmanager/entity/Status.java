package ru.kpp.incidentmanager.entity;

import javax.persistence.*;
import java.util.Objects;


/**
 * Класс сущности статуся заявки об инциденте, соответствует классу серверной части приложения, используется при
 * формировании справочника, используемого веб-формами
 */

@Entity
@Table(schema = "inm")
public class Status {
    private int id;
    private String title;

    public Status() {
    }

    public Status(int id, String title) {
        this.id = id;
        this.title = title;
    }

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
        Status status = (Status) o;
        return id == status.id &&
                Objects.equals(title, status.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
