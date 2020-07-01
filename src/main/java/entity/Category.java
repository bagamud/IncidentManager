package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {
    private int id;
    private int level;
    private int leftKey;
    private int rightKey;
    private String title;
    private int parentId;
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
    @Column(name = "LEVEL", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "LEFT_KEY", nullable = false)
    public int getLeftKey() {
        return leftKey;
    }

    public void setLeftKey(int leftKey) {
        this.leftKey = leftKey;
    }

    @Basic
    @Column(name = "RIGHT_KEY", nullable = false)
    public int getRightKey() {
        return rightKey;
    }

    public void setRightKey(int rightKey) {
        this.rightKey = rightKey;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "PARENT_ID", nullable = false)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id &&
                level == category.level &&
                leftKey == category.leftKey &&
                rightKey == category.rightKey &&
                parentId == category.parentId &&
                Objects.equals(title, category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, level, leftKey, rightKey, title, parentId);
    }

    @OneToMany(mappedBy = "categoryByCategory")
    public Collection<Incident> getIncidentsById() {
        return incidentsById;
    }

    public void setIncidentsById(Collection<Incident> incidentsById) {
        this.incidentsById = incidentsById;
    }
}
