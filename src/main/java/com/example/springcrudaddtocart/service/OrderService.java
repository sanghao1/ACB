package com.example.springcrudaddtocart.service;



import com.example.springcrudaddtocart.model.Order;
import com.example.springcrudaddtocart.model.OrderDetail;

import java.util.List;

public interface OrderService {
    void saveOrderWithOrderDetail(Order order, List<OrderDetail> orderDetails);
    List<Order> getAllOrder();
    List<OrderDetail> getOrderDetailByOrder(Long id);
}
