package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Department {
    private int id;
    private String title;
    private Collection<Incident> incidentsById;

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
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @OneToMany(mappedBy = "departmentByRequesterDepartment")
    public Collection<Incident> getIncidentsById() {
        return incidentsById;
    }

    public void setIncidentsById(Collection<Incident> incidentsById) {
        this.incidentsById = incidentsById;
    }
}
