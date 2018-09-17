package com.lzc.user.service.impl;

import com.lzc.user.dataobject.UserInfo;
import com.lzc.user.repository.UserInfoRepository;
import com.lzc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lzc
 * 2018/9/16 19:16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findByOpenId(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
