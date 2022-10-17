package com.dcxuexi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * @Title ServiceConfig
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/12 22:30
 * @Version 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "service")
public class ServiceConfig {
    private String ipAddress;
    private Integer port;
    private long timeout;
}
