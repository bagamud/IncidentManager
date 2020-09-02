package ru.kpp.inm_client.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
    private int id;
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
        Status incStatus = (Status) o;
        return id == incStatus.id &&
                Objects.equals(title, incStatus.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
