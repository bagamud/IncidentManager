package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Priority {
    private int id;
    private Integer influence;
    private Integer urgency;
    private String description;
    private String term;

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
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Priority priority = (Priority) o;

        if (id != priority.id) return false;
        if (influence != null ? !influence.equals(priority.influence) : priority.influence != null) return false;
        if (urgency != null ? !urgency.equals(priority.urgency) : priority.urgency != null) return false;
        if (description != null ? !description.equals(priority.description) : priority.description != null)
            return false;
        if (term != null ? !term.equals(priority.term) : priority.term != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (influence != null ? influence.hashCode() : 0);
        result = 31 * result + (urgency != null ? urgency.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        return result;
    }
}
