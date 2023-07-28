package com.example.springcrudaddtocart.model;

import com.example.springcrudaddtocart.entity.OrderDetailEntity;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private Long id;
    private LocalDateTime orderDate = LocalDateTime.now();
    private String customerName;
    private String customerAddress;
    List<OrderDetailEntity> orderDetails;
}
