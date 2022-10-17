package com.dcxuexi.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.dcxuexi.cofing.CommonConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CommonConfig commonConfig;


    @GetMapping
    public String getInfo(){
        return "作者："+commonConfig.getUsrname()+"，来自："+ commonConfig.getAddress()+
                "，国家："+ commonConfig.getCountry()+"，省份："+ commonConfig.getProvince()+"，城市："+ commonConfig.getCity()+"，地区："+ commonConfig.getArea();
    }

}
