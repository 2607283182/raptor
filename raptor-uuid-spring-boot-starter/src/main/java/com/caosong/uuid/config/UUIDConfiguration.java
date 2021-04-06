package com.caosong.uuid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caosong.uuid.service.UUIDService;

/**
 * @Author caosong
 * @Description //TODO
 * @Date 2021/4/6 16:12
 **/
@Configuration
@EnableConfigurationProperties(UUIDServiceProperties.class)
public class UUIDConfiguration {

    @Autowired
    private UUIDServiceProperties uuidServiceProperties;

    @Bean
    @ConditionalOnProperty(prefix = "com.caosong.uuid",name = "enable",havingValue = "true")
    public UUIDService uuidService() {
        UUIDService uuidService = new UUIDService(uuidServiceProperties.getDatacenterId(), uuidServiceProperties.getMachineId());
        return uuidService;
    }
}
