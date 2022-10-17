package com.xuexi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Title BookController
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/12 20:53
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/book")
public class BookController {


    @GetMapping
    public  String getAll(){

        System.out.println("SpringBoot_12_hot_deploy : this is a bookController......");
        System.out.println("SpringBoot_12_hot_deploy : this is a bookController......");
        System.out.println("SpringBoot_12_hot_deploy : this is a bookController......");
        return "SpringBoot_12_hot_deploy : this is a bookController......";
    }

}
