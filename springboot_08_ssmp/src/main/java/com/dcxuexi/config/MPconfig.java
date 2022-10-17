package com.dcxuexi.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * @Title MPconfig
 * @Description TOTD  数据库 拦截器
 * @Auter DongChuang
 * @Date 2022/9/8 20:52
 * @Version 1.0.0
 */
@Configuration
public class MPconfig {

    @Bean
    public MybatisPlusInterceptor mpInterceptor(){
        // 定义 MP 拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加具体的拦截器 分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());

        return  interceptor;


    }


}
