package com.caosong.raptor.jwt.service;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Author caosong
 * @Description
 * @Date 2021/4/8 16:27
 **/
public class JWTService {
    /**
     * 秘钥盐值
     */
    private String secret ;
    /**
     * Token过期时间
     */
    private Integer minutes ;

    public JWTService(String secret, Integer minutes) {
        this.secret = secret;
        this.minutes = minutes;
    }

    /**
     * 获得TOKEN,取默认时间。
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getAccessToken(Object data) throws UnsupportedEncodingException {
        String claimData = JSON.toJSONString(data);
        String token = JWT.create()
                .withClaim("data", claimData)
                .withExpiresAt(new Date(System.currentTimeMillis()+minutes*60*1000))
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    /**
     * 获得TOKEN，自定义TOKEN时间
     * @param data
     * @param minutes
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getAccessToken(Object data,Integer minutes) throws UnsupportedEncodingException {
        String claimData = JSON.toJSONString(data);
        String token = JWT.create()
                .withClaim("data", claimData)
                .withExpiresAt(new Date(System.currentTimeMillis()+minutes*60*1000))
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    /**
     * 更新TOKEN
     * @param token
     * @return
     * @throws UnsupportedEncodingException
     */
    public String updateAccessToken(String token) throws UnsupportedEncodingException {
        if(checkToken(token)){
            Object data = JWT.decode(token).getClaim("data");
            String accessToken = getAccessToken(data);
            return accessToken;
        }else{
            return null;
        }
    }

    /**
     * 校验TOKEN，如果TOKEN正确，返回True 否则返回False
     * @param token
     * @return
     */
    public boolean checkToken(String token) {
        Date date = JWT.decode(token).getExpiresAt();
        Date now = new Date();
        if(date.before(now)){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 获得JSON数据，如果TOKEN过期的话，则获取的是NULL
     * @param token
     * @return
     */
    public String getData(String token){
        if(checkToken(token)){
            String data = JWT.decode(token).getClaim("data").as(String.class);
            return data;
        }else{
            return null;
        }

    }
}
