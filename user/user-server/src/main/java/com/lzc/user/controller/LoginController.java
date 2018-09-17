package com.lzc.user.controller;

import com.lzc.user.VO.ResultVO;
import com.lzc.user.constant.CookieConstant;
import com.lzc.user.constant.RedisConstant;
import com.lzc.user.dataobject.UserInfo;
import com.lzc.user.enums.ResultEnum;
import com.lzc.user.enums.RoleEnum;
import com.lzc.user.service.UserService;
import com.lzc.user.utils.CookieUtil;
import com.lzc.user.utils.ResultVOUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by lzc
 * 2018/9/16 19:17
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 买家登录
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response) {

        // 1.openid和数据库里的数据进行匹配
        UserInfo userInfo = userService.findByOpenId(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        // 2. 判断角色
        if(RoleEnum.BUYER.getCode()!=userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        // 3. 设置cookie
        CookieUtil.set(response, CookieConstant.OPENID,openid,CookieConstant.expire);

        return ResultVOUtil.success();
    }

    /**
     * 卖家登录
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletResponse response, HttpServletRequest request) {
        // 判断是否已登录
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie != null &&
                !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
            return ResultVOUtil.success();
        }
        // 1.openid和数据库里的数据进行匹配
        UserInfo userInfo = userService.findByOpenId(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        // 2. 判断角色
        if(RoleEnum.SELLER.getCode()!=userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        // 3. redis设置key
        String token = UUID.randomUUID().toString();
        Integer expire = 7200;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token), openid, expire, TimeUnit.SECONDS);

        // 4. 设置cookie
        CookieUtil.set(response, CookieConstant.TOKEN,token,CookieConstant.expire);

        return ResultVOUtil.success();
    }
}
