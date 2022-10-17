package com.dcxuexi.controller;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Title BookController
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/12 18:56
 * @Version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    // 创建记录日志的对象
    //public static final Logger log = LoggerFactory.getLogger(BookController.class);


    @GetMapping
    public String getAll(){
        System.out.println("Springboot_11_log, this is a book....");
        log.info("info .... ");
        log.warn("warn .... ");
        log.debug("debug  .... ");
        log.error("error .... ");


        return "Springboot_11_log, this is a book....";
    }
}
