package ru.kpp.incidentmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    @Column(columnDefinition = "TEXT")
    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }
}