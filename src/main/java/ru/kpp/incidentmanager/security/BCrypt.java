package ru.kpp.incidentmanager.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class BCrypt {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.print("Введите пароль пользователя: ");
            String pas = bufferedReader.readLine();
            System.out.print("Base64: ");
            System.out.println(Base64.getEncoder().encodeToString(pas.getBytes()));
            System.out.print("BCrypt: ");
            System.out.println(passwordEncoder.encode(pas));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
