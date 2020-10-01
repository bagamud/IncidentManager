package ru.kpp.incidentmanager.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * В данном классе определяется конфигурация веб-безопасности приложения в части, определения порядка доступа к ресурсам
 * приложения и рапределения доступа к ресурсам авторизованных и неавторизованных пользователей,
 * определяения службы кодирования паролей и определяения конфигурации службы аутентификации
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Объявление сервиса, формирующего сведения о пользователе
     */
    final
    UsersService usersService;

    public WebSecurityConfig(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * Метод определяет порядок защиты доступа к ресурсам приложение по URL-путям
     *
     * @param http элемент конфигурации безопасности отвечающий за HTTP-запросы
     * @throws Exception общие исключения в процессе доступа к ресурсам
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/dashboard", "/manager").authenticated()
                .and()
                .httpBasic()
                .realmName("Incident Manager")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll().defaultSuccessUrl("/dashboard")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    /**
     * Метод определяет службу, кодирующую пароли
     *
     * @return экземпляр службы кодирования
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Метод определяющий конфигурацию службы аутентификации пользователей
     *
     * @param builder экземпляр менеджера аутентификации
     * @throws Exception проброс общих исключений формирования менеджера
     */

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(usersService).passwordEncoder(passwordEncoder());
    }
}
