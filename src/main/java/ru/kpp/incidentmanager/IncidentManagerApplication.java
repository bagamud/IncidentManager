package ru.kpp.incidentmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Основной класс приложения, аннотация {@link SpringBootApplication} реализует функции автоконфигурации приложения,
 * сканирования проекта на наличие дополнительных компонентов и их развертывание
 */

@SpringBootApplication
public class IncidentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncidentManagerApplication.class, args);
    }

}
