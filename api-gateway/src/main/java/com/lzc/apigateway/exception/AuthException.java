package com.lzc.apigateway.exception;

/**
 * Created by lzc
 * 2018/9/16 20:49
 */
public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
