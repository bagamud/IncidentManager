package ru.kpp.incidentmanager;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Класс, необходимый для развертывания приложения в формате war с переопределенным
 * методом конфигурации, в который передается основной класс приложения
 * {@link IncidentManagerApplication}, как ресурс
 */

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IncidentManagerApplication.class);
    }

}
