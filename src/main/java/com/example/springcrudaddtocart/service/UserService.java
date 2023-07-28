package com.example.springcrudaddtocart.service;

import com.example.springcrudaddtocart.model.User;


public interface UserService {
    Long createUser(User user);
    User findByUserId(Long userId);


}
