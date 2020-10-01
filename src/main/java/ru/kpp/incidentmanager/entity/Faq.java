package ru.kpp.incidentmanager.entity;

import javax.persistence.*;

/**
 * Класс сущности, содержащий переменные справочника базы знаний
 * В настоящем приложении используется в веб-форме manager.jsp для отображения подсказки пользователю по алгоритму действий
 * при выборе соответствующей категории инцидента из списка формы
 */
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