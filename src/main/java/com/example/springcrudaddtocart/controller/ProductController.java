package com.example.springcrudaddtocart.controller;


import com.example.springcrudaddtocart.entity.ProductEntity;
import com.example.springcrudaddtocart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("product", new ProductEntity());

        return "home";
    }

    @GetMapping("/producr-register")
    public String productRegister() {
        return "product-register";

    }
}
