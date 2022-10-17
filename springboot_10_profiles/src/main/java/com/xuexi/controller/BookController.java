package com.xuexi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Title BookController
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/12 17:48
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping
    public String getBook(){
        System.out.println("Spring_10_profiles, this is a book controller");
        return "Spring_10_profiles, this is a book controller";
    }

}
