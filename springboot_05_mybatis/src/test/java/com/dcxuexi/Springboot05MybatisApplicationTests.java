package com.dcxuexi;

import com.dcxuexi.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println(userDao.getById(1));
        //?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai

    }

}
