package com.lzc.hystrix.client;

import com.lzc.hystrix.client.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product", fallback = ProductClientFallback.class) // name代表商品服务的实例名称
public interface ProductClient {
    @GetMapping("/msg") // 这个路由一定要跟商品服务的路由保持一致，方法名可以任意填写
    public String msg();
}
