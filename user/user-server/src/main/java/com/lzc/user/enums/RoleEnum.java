package com.lzc.user.enums;

import lombok.Getter;

/**
 * Created by lzc
 * 2018/9/16 19:30
 */
@Getter
public enum RoleEnum {
    BUYER(1,"买家"),
    SELLER(2,"卖家")
    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
