package com.taraskina.eshop.controller;

import com.taraskina.eshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@AllArgsConstructor
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/index")
    public String indexPage(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "product/index";
    }
}
