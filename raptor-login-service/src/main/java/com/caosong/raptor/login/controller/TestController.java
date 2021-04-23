package com.caosong.raptor.login.controller;
import com.caosong.raptor.common.utils.result.Result;
import com.caosong.raptor.jwt.service.JWTService;
import com.caosong.raptor.login.entity.TbUser;
import com.caosong.raptor.uuid.service.UUIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;

/**
 * @Author caosong
 * @Description //TODO
 * @Date 2021/4/9 16:03
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisTemplate<String, Object> template;
    @Autowired
    private UUIDService uuidService;
    @Autowired
    private JWTService jwtService;
    @RequestMapping("/getUUID")
    public String getUUID(){
    return String.valueOf(uuidService.nextId());
    }
    @RequestMapping("/getToken")
    public String getToken() throws UnsupportedEncodingException {
        TbUser tbUser= new TbUser();
        tbUser.setUserAccount("123");
        tbUser.setUserPassword("445");
        String token = jwtService.getAccessToken(tbUser);
        return token;
    }
    @RequestMapping("/checkToken")
    public String checkToken(@PathParam("token") String token) throws UnsupportedEncodingException {
        return String.valueOf(jwtService.checkToken(token));

    }
    @RequestMapping("/getData")
    public Result getData(@PathParam("token") String token) {

        return Result.success();

    }
    @RequestMapping("/redisTest")
    public String redisTest(){
        // https://www.cnblogs.com/caizhaokai/p/11037610.html
        ValueOperations<String, Object> redisString = template.opsForValue();
        // SET key value: 设置指定 key 的值
        redisString.set("strKey1", "hello spring boot redis");
        return redisString.get("strKey1").toString();

    }
}
