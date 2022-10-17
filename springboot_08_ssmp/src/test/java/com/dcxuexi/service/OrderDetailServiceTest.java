package com.dcxuexi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dcxuexi.domian.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.awt.SunHints;

import java.util.List;

/***
 * @Title OrderDetailServiceTest
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/8 22:28
 * @Version 1.0.0
 */
@SpringBootTest
public class OrderDetailServiceTest {

    @Autowired
    private OrderDetailService orderDetailService;



    @Test
    void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setUserId(1);
        orderDetail.setUserName("方德保险代理");
        orderDetail.setTunnelName("北京瑞升领航");
        orderDetail.setTunnelSn("BJRSLHKJ");
        orderDetail.setAmount(10000);
        
        boolean b = orderDetailService.save(orderDetail);
        System.out.println(b);

    }

    @Test
    void testUpdate(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(366);
        orderDetail.setUserId(1);
        orderDetail.setUserName("方德保险代理");
        orderDetail.setTunnelName("北京瑞升领航");
        boolean b = orderDetailService.update(orderDetail);
        System.out.println(b);

    }

    @Test
    void testDelete(){
        //OrderDetail orderDetail = new OrderDetail();
        //orderDetail.setId(366);
        boolean b = orderDetailService.delete(366);
        System.out.println(b);
    }

    @Test
    void testSelectPage(){
        IPage<OrderDetail> iPage = orderDetailService.selectPage(2, 5);
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getPages());
        System.out.println(iPage.getTotal());
        iPage.getRecords().forEach(System.out::println);
    }

    @Test
    void testSelectAll(){
        List<OrderDetail> orderDetailList = orderDetailService.selectAll();
        orderDetailList.forEach(System.out::println);
    }

    @Test
    void testSelectById(){
        OrderDetail orderDetail = orderDetailService.selectById(334);
        System.out.println(orderDetail);
    }









}
