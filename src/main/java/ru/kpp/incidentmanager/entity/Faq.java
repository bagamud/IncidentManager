package ru.kpp.incidentmanager.entity;

import javax.persistence.*;

@Entity
@Table(schema = "inm")
public class Faq {
    int id;
    String cardTitle;
    String cardText;

    @Id
    @Column
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column
    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    @Basic
    @Column(columnDefinition = "TEXT")
    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }
}