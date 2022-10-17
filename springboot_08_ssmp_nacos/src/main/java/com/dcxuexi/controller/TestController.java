package com.dcxuexi.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Title TestController
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/18 22:33
 * @Version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @NacosValue(value = "${upload.username}",autoRefreshed = true)
    private String usrname;


    @NacosValue(value ="${upload.address}",autoRefreshed = true)
    private String address;


    @GetMapping
    public String getInfo(){
        return "作者："+usrname+"，来自："+address;
    }

}
