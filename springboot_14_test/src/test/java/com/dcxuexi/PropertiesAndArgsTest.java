package com.dcxuexi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/***
 * @Title PropertiesAndArgsTest
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/14 21:02
 * @Version 1.0.0
 */
// properties 属性可以为当前测试用例添加临时的属性配置
//@SpringBootTest(properties = {"test.prop=testValue1"})
//args 属性可以为当前测试用例添加临时的命令行参数
//@SpringBootTest(args = {"--test.prop = testValue2"})
@SpringBootTest(properties = {"test.prop=testValue1"},args = {"--test.prop = testValue2"})
public class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String msg;

    @Test
    void testProperties(){
        System.out.println(msg);


    }
}
