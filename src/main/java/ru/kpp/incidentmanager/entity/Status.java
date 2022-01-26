package ru.kpp.incidentmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


/**
 * Класс сущности статуся заявки об инциденте, используется при формировании справочника, используемого веб-формами
 */

@Entity
@Table(schema = "inm")
public class Status {
    private int id;
    private String title;
    private boolean done;

    public Status() {
    }

    public Status(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
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
