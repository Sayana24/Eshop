package com.taraskina.eshop.controller;

import com.taraskina.eshop.entity.Person;
import com.taraskina.eshop.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class LoginController {

    private PasswordEncoder passwordEncoder;
    private PersonService personService;
    @GetMapping("/login")
    public String login(){

        return "user/login";
    }
    @GetMapping("/register")
    public String register(){

        return "user/register";
    }
    @PostMapping("/register/load")
    public String registerLoad(@ModelAttribute Person person){
        /*String username = model.getAttribute("username").toString();
        String password = model.getAttribute("password").toString();
        String passwordEnc = passwordEncoder.encode(password);
        String email = model.getAttribute("email").toString();
        String phone = model.getAttribute("phone").toString();*/


        /*Person person = new Person(username, passwordEnc, email);
        person.setPhone(phone);*/
        personService.save(person);

        return "user/registered";
    }
}