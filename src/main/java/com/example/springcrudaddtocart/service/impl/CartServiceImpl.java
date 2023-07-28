package com.example.springcrudaddtocart.service.impl;


import com.example.springcrudaddtocart.model.Cart;
import com.example.springcrudaddtocart.model.OrderDetail;
import com.example.springcrudaddtocart.model.Product;
import com.example.springcrudaddtocart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    Cart cart;

    @Override
    public List<OrderDetail> getShoppingCart() {
        return cart.getListItems();
    }

    @Override
    public void removeItem(int cartId) {

    }

    @Override
    public void emptyCart() {

    }

    @Override
    public Integer count() {
        return null;
    }

    @Override
    public boolean checkExist(Product product) {
        return false;
    }


    @Override
    public void addToCart(Product product) {
        cart.getListItems().stream()
                .filter(item -> item.getProduct().getId() == product.getId())
                .findFirst()
                .ifPresentOrElse(item -> item.setQuantity(item.getQuantity() + 1),
                        () -> {
                            OrderDetail newItem = new OrderDetail();
                            newItem.setQuantity(1);
                            newItem.setProduct(product);
                            cart.getListItems().add(newItem);
                        }
                );
    }

}