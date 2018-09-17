package com.lzc.hystrix.client.fallback;


import com.lzc.hystrix.client.ProductClient;
import org.springframework.stereotype.Component;

/**
 * Created by lzc
 * 2018/9/17 9:23
 */
@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public String msg() {
        return "服务错误";
    }
}
