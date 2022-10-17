package com.dcxuexi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dcxuexi.domian.OrderDetail;

import java.util.List;

/***
 * @Title IOrderDetailService
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/8 22:48
 * @Version 1.0.0
 */
public interface IOrderDetailService extends IService<OrderDetail> {

    // 新增方法
    List<OrderDetail> selectUserName();

}
