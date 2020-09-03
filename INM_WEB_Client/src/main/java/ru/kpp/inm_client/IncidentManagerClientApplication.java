package ru.kpp.inm_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IncidentManagerClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IncidentManagerClientApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IncidentManagerClientApplication.class);
    }

}