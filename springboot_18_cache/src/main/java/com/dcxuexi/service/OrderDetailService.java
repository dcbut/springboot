package com.dcxuexi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dcxuexi.dao.OrderDetailDao;
import com.dcxuexi.domain.OrderDetail;

import java.util.List;

/***
 * @Title OrderDetailService
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/10/3 20:44
 * @Version 1.0.0
 */
public interface OrderDetailService extends IService<OrderDetail> {
    // 新增方法
    List<OrderDetail> selectUserName();

    OrderDetail getById(Integer id);


}
