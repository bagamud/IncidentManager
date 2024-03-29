package ru.kpp.incidentmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


/**
 * Класс сущности приоритета инцидента, используется в классе {@link ru.kpp.incidentmanager.entity.Incident Incident},
 * а также при формировании справочника, используемого веб-формами
 */

@Entity
@Table(schema = "inm")
public class Priority {
    private int id;
    //    private int influence;
//    private int urgency;
    private String description;
    private int term;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "INFLUENCE")
//    public int getInfluence() {
//        return influence;
//    }
//
//    public void setInfluence(int influence) {
//        this.influence = influence;
//    }
//
//    @Basic
//    @Column(name = "URGENCY")
//    public int getUrgency() {
//        return urgency;
//    }
//
//    public void setUrgency(int urgency) {
//        this.urgency = urgency;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
//                influence == priority.influence &&
//                urgency == priority.urgency &&
                term == priority.term &&
                Objects.equals(description, priority.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, /*influence, urgency,*/ description, term);
    }
}
