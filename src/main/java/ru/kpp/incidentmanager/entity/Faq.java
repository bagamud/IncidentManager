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
    private int id;

    private Category category;

    private String cardTitle;
    private String cardText;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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