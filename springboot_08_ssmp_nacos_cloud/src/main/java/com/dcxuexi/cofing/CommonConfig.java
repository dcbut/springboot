package com.dcxuexi.cofing;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/***
 * @Title CommonConfig
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/26 21:53
 * @Version 1.0.0
 */

@Component
@RefreshScope
@Getter
public class CommonConfig {

    @Value(value = "${upload.username}")
    private String usrname;


    @Value(value ="${upload.address}")
    private String address;

    @Value(value ="${upload.country}")
    private String country;

    @Value(value ="${upload.province}")
    private String province;

    @Value(value ="${upload.city}")
    private String city;

    @Value(value ="${upload.area}")
    private String area;



}
