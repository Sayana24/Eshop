package com.taraskina.eshop;

import com.taraskina.eshop.entity.Category;
import com.taraskina.eshop.entity.Person;
import com.taraskina.eshop.entity.Product;
import com.taraskina.eshop.entity.Role;
import com.taraskina.eshop.service.CategoryService;
import com.taraskina.eshop.service.PersonService;
import com.taraskina.eshop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoadDatabase {
    private static final Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(ProductService productService,
                                   CategoryService categoryService,
                                   PersonService personService){
        return arg -> {

            Category category = categoryService.save(new Category("Уход за лицом"));

            Product product = productService.save(new Product("Крем для лица",
                    5000.00, "Хороший крем", category));

            LOG.info("Preloading " + product);
            Person userClient = personService.save(new Person("Masha",
                    passwordEncoder.encode("1234"),"Masha@mail.ru"));
            userClient.setRole(Role.USER);
            Person userAdmin = personService.save(new Person("Alex",
                    passwordEncoder.encode("sekret"), "Alex@mail.ru"));
            userAdmin.setRole(Role.ADMIN);
            LOG.info(("Preloading " + personService.save(userClient)));
            LOG.info(("Preloading " + personService.save(userAdmin)));


        };
    }
}
