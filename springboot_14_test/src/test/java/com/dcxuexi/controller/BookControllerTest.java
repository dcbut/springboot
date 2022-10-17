package com.dcxuexi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/***
 * @Title BookControllerTest
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/14 22:05
 * @Version 1.0.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 开启虚拟MVC调用
@AutoConfigureMockMvc
public class BookControllerTest {



    @Test
    void testWeb(){
    }

    @Test
    //注入虚拟MVC调用对象
    void testWebReq(@Autowired MockMvc mockMvc) throws Exception {
        //创建虚拟请求，当前访问的是 /book
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/book");
        //执行请求
        ResultActions actions = mockMvc.perform(builder);

    }


    @Test
    void testStatus(@Autowired MockMvc mockMvc) throws Exception {
        //创建虚拟请求，当前访问的是 /book
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/book");
        //执行请求
        ResultActions actions = mockMvc.perform(builder);
        //匹配执行状态（是否是预期值）
        //定义执行状态匹配器
        StatusResultMatchers status = MockMvcResultMatchers.status();
        //自定义预期执行状态
        ResultMatcher ok = status.isOk();
        //使用本次真实执行结果与预期结果进行比较
        actions.andExpect(ok);

    }


    @Test
    void testBody(@Autowired MockMvc mockMvc) throws Exception {
        //创建虚拟请求，当前访问的是 /book
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/book");
        //执行请求
        ResultActions actions = mockMvc.perform(builder);
        //匹配执行状态（是否是预期值）
        //定义执行状态匹配器
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //自定义预期执行结果
        ResultMatcher resultMatcher = content.string("getById");
        //使用本次真实执行结果与预期结果进行比较
        actions.andExpect(resultMatcher);

    }





}
