package com.caosong.raptor.uuid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caosong.raptor.uuid.service.UUIDService;

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


    /**
     * 注入UUIDService，数据中心ID和机器ID必须有值才让注入。
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "com.caosong.raptor.uuid",name = {"datacenterId","machineId"})
    public UUIDService uuidService() {
        UUIDService uuidService = new UUIDService(uuidServiceProperties.getDatacenterId(), uuidServiceProperties.getMachineId());
        return uuidService;
    }
}
