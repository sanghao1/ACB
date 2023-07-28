package com.example.springcrudaddtocart.service.impl;


import com.example.springcrudaddtocart.converter.UserConverter;
import com.example.springcrudaddtocart.model.User;
import com.example.springcrudaddtocart.repository.UserRepository;
import com.example.springcrudaddtocart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Long createUser(User user) {
        return userRepository.save(UserConverter.toEntity(user)).getId();
    }

    @Override
    public User findByUserId(Long userId) {
        return UserConverter.toModel(userRepository.findByUserId(userId));
    }
}
