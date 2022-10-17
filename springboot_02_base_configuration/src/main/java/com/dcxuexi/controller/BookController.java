package com.dcxuexi.controller;

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

    @GetMapping
    public String getStr(){
        System.out.println("spring is running...");
        return "springboot is running... 2";
    }



}
