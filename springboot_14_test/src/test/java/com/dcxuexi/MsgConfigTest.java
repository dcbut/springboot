package com.dcxuexi;

import com.dcxuexi.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/***
 * @Title MsgConfigTest
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/14 21:35
 * @Version 1.0.0
 */
@SpringBootTest
@Import(MsgConfig.class)
public class MsgConfigTest {
    @Autowired
    private String msg;

    @Test
    public  void testMsg(){
        System.out.println(msg);
    }
}
