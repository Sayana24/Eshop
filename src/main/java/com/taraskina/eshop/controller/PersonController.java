package com.taraskina.eshop.controller;

import com.taraskina.eshop.entity.User;
import com.taraskina.eshop.service.UserService;
import com.taraskina.eshop.service.impl.UserServiceImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController implements UserDetailsService {
    private UserServiceImpl userService;

    public UserController(UserServiceImpl service) {
        this.userService = service;
    }

    @GetMapping("/users")
    public String all(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "user/users";
    }

    @GetMapping("/users/{id}")
    public String find(@PathVariable long id,
                       Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/user";
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userService.findByName(username)
                .map(p -> new User(
                        p.getName(),
                        p.getPassword(),
                        Collections.singleton(p.getRole())
                )).orElseThrow(() ->
                        new UsernameNotFoundException("Cannot find user: "
                                + username));
        return userDetails;
    }
}