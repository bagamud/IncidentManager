package ru.kpp.inm_client.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private int id;
    private int level;
    private int leftKey;
    private int rightKey;
    private String title;
    private int parentId;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLeftKey() {
        return leftKey;
    }

    public void setLeftKey(int leftKey) {
        this.leftKey = leftKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public void setRightKey(int rightKey) {
        this.rightKey = rightKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
}
