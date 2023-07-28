package com.example.springcrudaddtocart.converter;


import com.example.springcrudaddtocart.entity.UserEntity;
import com.example.springcrudaddtocart.model.User;
import org.springframework.stereotype.Component;

public class UserConverter{
    public static User toModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setAge(userEntity.getAge());
        user.setPassword(userEntity.getPassword());
        return user;
    }
    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setAge(user.getAge());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}
