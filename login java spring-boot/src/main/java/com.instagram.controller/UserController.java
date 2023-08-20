package com.instagram.controller;

import com.instagram.service.UserService;
import com.instagram.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{username}/{password}")
    public int user(@PathVariable ("username") String username1,@PathVariable("password")String password1) throws SQLException {
        int flag=userService.LoginValidation(username1,password1);
        if (flag == 0) {
            return 0;
        }
        return 1;
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello Calling";
    }
    @GetMapping("getname/{uname}")
    public String users(@PathVariable("uname")String uname1) throws SQLException {
        String gn = userService.getName(uname1);
        return "  " +gn;
    }
}
