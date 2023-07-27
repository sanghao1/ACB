package com.example.springcrudaddtocart.entity;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartEntity {
    private OrderEntity orderEntity = new OrderEntity();

    public void addItem(ProductEntity productEntity) {

        OrderDetailEntity detail = new OrderDetailEntity();
        detail.setProductEntity(productEntity);
        detail.setQuantity(1);
        orderEntity.getOrderDetailEntities().add(detail);

        print();
    }

    public void removeItem(ProductEntity productEntity) {
        OrderDetailEntity detail = Optional.of(orderEntity.getOrderDetailEntities())
                .orElse(new ArrayList<>())
                .stream()
                // Tìm xem đã có product nào cùng loại trước đó chưa
                .filter(item -> Objects.equals(item.getProductEntity().getId(), productEntity.getId()))
                .findFirst()
                // Nếu chưa có thì tạo ra 1 order detail mới với product chính là product trong tham số của hàm
                // Khi nào quantity sẽ là 0
                .orElse(new OrderDetailEntity());

        orderEntity.getOrderDetailEntities().remove(detail);
        print();
    }

    public void emptyCart() {
        orderEntity.setOrderDetailEntities(List.of());
        print();
    }

    public int count() {
        return this.orderEntity.getOrderDetailEntities()
                .stream()
                .map(OrderDetailEntity::getQuantity)
                .reduce(0, Integer::sum);
    }

    private void print() {
        Optional.ofNullable(orderEntity.getOrderDetailEntities())
                .orElse(new ArrayList<>())
                .forEach(item -> {
                    System.out.println("ProductId: " + item.getProductEntity().getId());
                    System.out.println("Quantity: " + item.getQuantity());
                    System.out.println("===========");
                });
    }
}