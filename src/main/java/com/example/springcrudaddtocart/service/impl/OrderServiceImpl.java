package com.example.springcrudaddtocart.service.impl;


import com.example.springcrudaddtocart.converter.OrderConverter;
import com.example.springcrudaddtocart.converter.OrderDetailConverter;
import com.example.springcrudaddtocart.entity.OrderDetailEntity;
import com.example.springcrudaddtocart.entity.OrderEntity;
import com.example.springcrudaddtocart.model.Order;
import com.example.springcrudaddtocart.model.OrderDetail;
import com.example.springcrudaddtocart.repository.OrderDetailRepository;
import com.example.springcrudaddtocart.repository.OrderRepository;
import com.example.springcrudaddtocart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Transactional
    @Override
    public void saveOrderWithOrderDetail(Order order, List<OrderDetail> orderDetails) {
        OrderEntity newOrder = orderRepository.save(OrderConverter.transferToEntity(order));

        orderDetails.stream().forEach(detail->{
            detail.setOrder(OrderConverter.transferToModel(newOrder));
        });
        List<OrderDetailEntity> listDetailEntities = orderDetails.stream()
                                                                    .map(OrderDetailConverter::trasferToEntity)
                                                                    .toList();

        listDetailEntities.stream().forEach(detail->{
            orderDetailRepository.save(detail);
        });
    }

    @Override
    public List<Order> getAllOrder() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return orderEntities.stream().map(OrderConverter::transferToModel).collect(Collectors.toList());
    }

    @Override
    public List<OrderDetail> getOrderDetailByOrder(Long id) {
        List<OrderDetailEntity> orderDetailEntities = orderRepository.findById(id).get().getOrderDetails();
        return orderDetailEntities.stream().map(OrderDetailConverter::transferToModel).collect(Collectors.toList());
    }
}
