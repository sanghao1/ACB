package com.example.springcrudaddtocart.service.impl;

import com.example.springcrudaddtocart.entity.ProductEntity;
import com.example.springcrudaddtocart.repository.ProductRepository;
import com.example.springcrudaddtocart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired private ProductRepository repository;

    @Override
    public List<ProductEntity> getAll() {
        return repository.findAll();
    }
}
