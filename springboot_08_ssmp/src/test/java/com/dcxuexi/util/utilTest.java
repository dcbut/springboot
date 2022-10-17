package com.dcxuexi.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/***
 * @Title util
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/11 10:31
 * @Version 1.0.0
 */
@SpringBootTest
public class utilTest {

    @Test
    void testmd5(){

        // md5 加密
        String s1 = DigestUtils.md5DigestAsHex("123456".getBytes());
        String s2 = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s1);
        System.out.println(s2);

        // spring 安全框架提供的加密方式，可以自己加盐，无需保存盐值
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode1 = passwordEncoder.encode("123456");
        String encode2 = passwordEncoder.encode("123456");
        System.out.println(encode1);
        System.out.println(encode2);

        // 验证
        boolean matches1 = passwordEncoder.matches("123456", "$2a$10$aucdyQtu1VP7ehXQU0NVcub0El8qmE77mh4otiC67whZrTE.9Nx5i");
        boolean matches2 = passwordEncoder.matches("123456", "$2a$10$PE1.1oTQMsosoCFFLrSmjeKkMXz2cmyP4bhwOD2GbIcnEzRGxy/Sa");
        boolean matches3 = passwordEncoder.matches("123456", encode1);
        boolean matches4 = passwordEncoder.matches("123456", encode2);
        System.out.println(matches1);
        System.out.println(matches2);
        System.out.println(matches3);
        System.out.println(matches4);

    }


}
