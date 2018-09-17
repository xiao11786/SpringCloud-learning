package com.lzc.configclient.controller;


import com.lzc.configclient.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

   @Autowired
   private User user;

    @GetMapping("/print")
    public Object print() {
        return user.toString();
    }
}
