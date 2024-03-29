package ru.kpp.incidentmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


/**
 * Класс сущности, содержащий переменные элемента вложенного множества категорий инцидентов
 * В настоящем клиенте представлен в классе {@link ru.kpp.incidentmanager.entity.Incident Incident},
 * а также в справочнике используемом для веб-форм
 */

@Entity
@Table(schema = "inm")
public class Category {

    @Id
    private int id;
    private String title;
    private int parentId;

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
                parentId == category.parentId &&
                Objects.equals(title, category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, parentId);
    }
}
