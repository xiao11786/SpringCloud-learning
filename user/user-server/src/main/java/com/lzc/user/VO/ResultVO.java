package com.lzc.user.VO;

import lombok.Data;

/**
 * Created by lzc
 *
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
