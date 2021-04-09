package com.caosong.raptor.jwt.config;

import com.caosong.raptor.jwt.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author caosong
 * @Description // JWT配置类
 * @Date 2021/4/9 15:59
 **/
@Configuration
@EnableConfigurationProperties(JWTConfigurationProperties.class)
public class JWTConfiguration {

    @Autowired
    private JWTConfigurationProperties properties;

    @Bean
    @ConditionalOnProperty(prefix="com.caosong.raptor.jwt",name = {"secret","minutes"})
    public JWTService jwtService(){
        return new JWTService(properties.getSecret(),properties.getMinutes());
    }
}
