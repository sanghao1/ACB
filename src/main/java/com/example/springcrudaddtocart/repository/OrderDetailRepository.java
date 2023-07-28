package com.example.springcrudaddtocart.repository;


import com.example.springcrudaddtocart.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long> {
}
