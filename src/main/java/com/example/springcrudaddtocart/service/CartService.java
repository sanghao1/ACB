package com.example.springcrudaddtocart.service;

import com.example.springcrudaddtocart.model.OrderDetail;
import com.example.springcrudaddtocart.model.Product;


import java.util.List;

public interface CartService {
    List<OrderDetail> getShoppingCart();
    void addToCart(Product product);
    void removeItem(int cartId);
    void emptyCart();
    Integer count();
    boolean checkExist(Product product);
}
