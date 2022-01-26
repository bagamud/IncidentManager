package ru.kpp.incidentmanager.securingweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Класс веб-конфигурации с методом добавления простых автоматических контроллеров представлений
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main").setViewName("auth");
        registry.addViewController("/").setViewName("auth");
        registry.addViewController("/login").setViewName("auth");
        registry.addViewController("/auth").setViewName("auth");
    }
}