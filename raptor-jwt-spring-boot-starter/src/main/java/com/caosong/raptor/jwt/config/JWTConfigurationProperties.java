package com.caosong.raptor.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author caosong
 * @Description //TODO
 * @Date 2021/4/9 15:55
 **/
@Data
@ConfigurationProperties(prefix = "com.caosong.raptor.jwt")
public class JWTConfigurationProperties {
    /**
     * 秘钥盐值
     */
    private String secret ;
    /**
     * Token过期时间
     */
    private Integer minutes ;
}
