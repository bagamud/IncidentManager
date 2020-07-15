package main.java.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@JsonAutoDetect
@Entity
@Table(name = "INC_STATUS", schema = "INM")
public class IncStatus {
    @JsonProperty
    private int id;
    @JsonProperty
    private String title;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncStatus incStatus = (IncStatus) o;
        return id == incStatus.id &&
                Objects.equals(title, incStatus.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
