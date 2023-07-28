package com.example.springcrudaddtocart.repository;


import com.example.springcrudaddtocart.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
