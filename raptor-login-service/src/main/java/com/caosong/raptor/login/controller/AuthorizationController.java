package com.caosong.raptor.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author caosong
 * @Description 认证Controller
 * @Date 2021/4/8 16:07
 **/
@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
    /**
     * 校验用户信息
     * @return
     */
    @RequestMapping(value = "/validateUserInfo",method = RequestMethod.POST)
    public String validateUserInfo(@RequestBody JSONObject userToken){
        String raptorToken = userToken.get("raptorToken").toString();

        return null;
    }
}
