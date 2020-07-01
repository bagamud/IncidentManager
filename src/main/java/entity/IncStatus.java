package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "INC_STATUS", schema = "INM")
public class IncStatus {
    private int id;
    private String title;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 255)
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
