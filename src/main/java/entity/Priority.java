package entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@JsonAutoDetect
@Entity(name = "PRIORITY")
public class Priority {
    @JsonProperty
    private int id;
    @JsonProperty
    private int influence;
    @JsonProperty
    private int urgency;
    @JsonProperty
    private String description;
    @JsonProperty
    private int term;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "INFLUENCE", nullable = false)
    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    @Basic
    @Column(name = "URGENCY", nullable = false)
    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "TERM", nullable = false)
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
                influence == priority.influence &&
                urgency == priority.urgency &&
                term == priority.term &&
                Objects.equals(description, priority.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, influence, urgency, description, term);
    }
}
