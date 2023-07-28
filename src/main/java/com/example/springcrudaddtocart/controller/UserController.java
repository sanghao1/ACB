package com.example.springcrudaddtocart.controller;

import com.example.springcrudaddtocart.model.User;
import com.example.springcrudaddtocart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("addNewUser")
    public String addNewUser(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        return "user/createForm";
    }

    @PostMapping("register")
    public String register(@ModelAttribute User user, Model model){
        Long id = userService.createUser(user);
        user.setId(id);
        model.addAttribute("message","Successfully - Id: "+id);
        return "user/result";
    }

    @GetMapping("getUserDetail/{userId}")
    public String getUserDetail(@PathVariable(name = "userId") Long userId, Model model){
        User user = userService.findByUserId(userId);
        model.addAttribute("user",user);
        return "user/detail";
    }
}

