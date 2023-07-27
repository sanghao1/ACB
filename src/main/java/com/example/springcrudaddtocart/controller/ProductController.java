package com.example.springcrudaddtocart.controller;


import com.example.springcrudaddtocart.entity.CartEntity;
import com.example.springcrudaddtocart.entity.ProductEntity;
import com.example.springcrudaddtocart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    @Autowired
    private CartEntity cartEntity;

    @PostMapping
    public String add(@ModelAttribute ProductEntity product, Model model) {
        System.out.println("requstID" + product.getId());
        cartEntity.addItem(product);

        model.addAttribute("products", productService.getAll());
        model.addAttribute("product", new ProductEntity());
        return "home-1";
    }

    @GetMapping("rest")
    public ResponseEntity<List<ProductEntity>> add() {
        return ResponseEntity.status(200).body(productService.getAll());
    }
}
