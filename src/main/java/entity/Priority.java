package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Priority {
    private int id;
    private Integer influence;
    private Integer urgency;
    private String description;
    private Integer term;
    private Collection<Incident> incidentsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "INFLUENCE")
    public Integer getInfluence() {
        return influence;
    }

    public void setInfluence(Integer influence) {
        this.influence = influence;
    }

    @Basic
    @Column(name = "URGENCY")
    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
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
    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority = (Priority) o;
        return id == priority.id &&
                Objects.equals(influence, priority.influence) &&
                Objects.equals(urgency, priority.urgency) &&
                Objects.equals(description, priority.description) &&
                Objects.equals(term, priority.term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, influence, urgency, description, term);
    }

    @OneToMany(mappedBy = "priorityByPriority")
    public Collection<Incident> getIncidentsById() {
        return incidentsById;
    }

    public void setIncidentsById(Collection<Incident> incidentsById) {
        this.incidentsById = incidentsById;
    }
}
