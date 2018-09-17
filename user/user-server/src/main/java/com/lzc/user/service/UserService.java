package com.lzc.user.service;

import com.lzc.user.dataobject.UserInfo;

/**
 * Created by lzc
 * 2018/9/16 19:15
 */
public interface UserService {

    UserInfo findByOpenId(String openid);
}
