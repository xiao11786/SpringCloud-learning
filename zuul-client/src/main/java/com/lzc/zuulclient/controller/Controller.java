package com.lzc.zuulclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {

    @GetMapping("/index1")
    public String index1(HttpServletRequest request){
        return "zuul-client index1";
    }

    @GetMapping("/index2")
    public String index2(){
        return "zuul-client index2";
    }

    @GetMapping("/order/create")
    public String orderCreate() {
        return "我是买家";
    }
    @GetMapping("/order/finished")
    public String orderFinished() {
        return "我是卖家";
    }
    @GetMapping("/product/list")
    public String productLis() {
        return "/product/list";
    }
}
