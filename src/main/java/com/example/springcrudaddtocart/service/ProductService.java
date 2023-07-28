package com.example.springcrudaddtocart.service;


import com.example.springcrudaddtocart.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    void createProduct(Product product);
    List<Product> getAllProduct();
}
