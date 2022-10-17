package com.dcxuexi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * @Title MpConfig
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/14 21:33
 * @Version 1.0.0
 */
@Configuration
public class MsgConfig {

    @Bean
    public String msg(){
        return "this is a MpConfig";
    }
}
