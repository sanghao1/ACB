package com.example.springcrudaddtocart.repository;


import com.example.springcrudaddtocart.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Query("select u from UserEntity u where u.id=:id")
    UserEntity findByUserId(Long id);
}
