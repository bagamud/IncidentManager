package ru.kpp.incidentmanager.entity;

import javax.persistence.*;
import java.util.Objects;


/**
 * Класс сущности приоритета инцидента, используется в классе {@link ru.kpp.incidentmanager.entity.Incident Incident},
 * а также при формировании справочника, используемого веб-формами
 */

@Entity
@Table(schema = "inm")
public class Priority {
    private int id;
    private String description;
    private int term;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "TERM")
    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority = (Priority) o;
        return id == priority.id &&
                term == priority.term &&
                Objects.equals(description, priority.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, term);
    }
}
