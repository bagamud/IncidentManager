//package ru.kpp.incidentmanager.controllers;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import ru.kpp.incidentmanager.entity.Users;
//import ru.kpp.incidentmanager.repositories.RolesRepository;
//import ru.kpp.incidentmanager.repositories.UsersRepository;
//
//import java.util.Collections;
//import java.util.List;
//
///**
// * Класс формирующий сведения о зарегистрированном пользователе
// * (username - имя пользователя, password - пароль, role - роль)
// * из базы данных для прохождения аутентификации с переданными
// * веб-сервису именем ползьвателя и паролем
// */
//
//@Service
//public class UsersService implements UserDetailsService {
//    final
//    UsersRepository usersRepository;
//    final
//    RolesRepository rolesRepository;
//
//    public UsersService(UsersRepository usersRepository, RolesRepository rolesRepository) {
//        this.usersRepository = usersRepository;
//        this.rolesRepository = rolesRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = usersRepository.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("Пользователь не найден");
//        }
//        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()));
//        return new User(user.getUsername(), user.getPassword(), authorities);
//    }
//}
