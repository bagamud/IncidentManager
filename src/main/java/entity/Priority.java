package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Priority {
    private int id;
    private int influence;
    private int urgency;
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
    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    @Basic
    @Column(name = "URGENCY")
    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
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
        if (influence != priority.influence) return false;
        if (urgency != priority.urgency) return false;
        if (description != null ? !description.equals(priority.description) : priority.description != null)
            return false;
        if (term != null ? !term.equals(priority.term) : priority.term != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + influence;
        result = 31 * result + urgency;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        return result;
    }
}
