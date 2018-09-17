package com.lzc.apigateway.exception;

/**
 * Created by lzc
 * 2018/9/16 16:33
 */
public class RateLimitException extends RuntimeException {
    public RateLimitException(String message) {
        super(message);
    }
}
