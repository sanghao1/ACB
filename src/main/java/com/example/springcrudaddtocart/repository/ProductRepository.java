package com.example.springcrudaddtocart.repository;

import com.example.springcrudaddtocart.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

}
