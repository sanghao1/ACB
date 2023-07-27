package com.example.springcrudaddtocart.controller;

import com.example.springcrudaddtocart.entity.CartEntity;
import com.example.springcrudaddtocart.entity.ProductEntity;
import com.example.springcrudaddtocart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartEntity cartEntity;

    @Autowired
    private ProductService productService;

    @PostMapping
    public String add(@ModelAttribute("product") ProductEntity product, Model model) {
        System.out.println("requstID" + product.getId());
        cartEntity.addItem(product);

        model.addAttribute("products", productService.getAll());
        model.addAttribute("product", new ProductEntity());
        return "product-list";
    }


}