package com.lzc.order.controller;

import com.lzc.order.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    // 方法2
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    // 方法3
//    @Autowired
//    private RestTemplate restTemplate;

    // 方法4
    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public Object getProductMsg() {
        // 方法1
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8082/msg",String.class);

        // 方法2（利用LoadBalancerClient通过应用名称获取URL，然后再使用RestTemplate），如果有多个应用，会采取负载均衡策略来选择不同的应用
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
//        System.out.println("请求地址:" + url);
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url,String.class);

        // 方法3（利用@LoadBalanced，可直接在RestTemplate使用应用名字来访问），如果有多个应用，会采取负载均衡策略来选择不同的应用
//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);

        String response = productClient.msg();
        return response;
    }
}
