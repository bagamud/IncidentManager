package ru.kpp.incidentmanager.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Category {
    private int id;
    private int level;
    private int leftkey;
    private int rightkey;
    private String title;
    private int parentId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LEVEL")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "LEFTKEY")
    public int getLeftkey() {
        return leftkey;
    }

    public void setLeftkey(int leftkey) {
        this.leftkey = leftkey;
    }

    @Basic
    @Column(name = "RIGHTKEY")
    public int getRightkey() {
        return rightkey;
    }

    public void setRightkey(int rightkey) {
        this.rightkey = rightkey;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "PARENT_ID")
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
                leftkey == category.leftkey &&
                rightkey == category.rightkey &&
                parentId == category.parentId &&
                Objects.equals(title, category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, level, leftkey, rightkey, title, parentId);
    }
}
