package com.dcxuexi.controller;

import com.dcxuexi.dao.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Title BookController
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/19 23:20
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Value("${province}")
    private String province;
    @Value("${city}")
    private String city;
    @Value("${area}")
    private String area;
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private String age;
    @Value("${like[1]}")
    private String like;
    @Value("${baseDir}")
    private String baseDir;
    @Value("${tmpDir}")
    private String tmpDir;
    @Value("${tmpDir2}")
    private String tmpDir2;
    @Value("${tmpDir3}")
    private String tmpDir3;

    // 自动加载yml 配置数据
    @Autowired
    private Environment env;
    @Autowired
    private MyDataSource myDataSource;



    @GetMapping
    public String getStr(){
        System.out.println("spring is running...");
        System.out.println("province ===> "+ province);
        System.out.println("city ===> "+ city);
        System.out.println("area ===> "+ area);
        System.out.println("user name ===> "+ name);
        System.out.println("user age ===> "+ age);
        System.out.println("user like ===>"+like);
        System.out.println("baseDir ===>"+baseDir);
        System.out.println("tmpDir ===>"+tmpDir);
        System.out.println("tmpDir2 ===>"+tmpDir2);
        System.out.println("tmpDir3 ===>"+tmpDir3);

        // -----------------
        System.out.println("================================");
        System.out.println("qitashuju yundong ===>"+env.getProperty("yundong"));
        System.out.println("qitashuju chihe ===>"+env.getProperty("chihe"));
        System.out.println("qitashuju hejiu ===>"+env.getProperty("hejiu"));

        System.out.println("================================");
        System.out.println("MyDataSource ===>"+myDataSource);

        return "springboot is running...";
    }



}
