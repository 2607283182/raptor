package com.caosong.uuid.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author caosong
 * @Description // UUID配置类
 * @Date 2021/4/6 15:55
 **/

@Data
@ConfigurationProperties(prefix = "com.caosong.uuid")
public class UUIDServiceProperties {
    private Integer datacenterId; // 数据中心ID
    private Integer machineId; // 机器标识
    private Boolean enable = false;
}
