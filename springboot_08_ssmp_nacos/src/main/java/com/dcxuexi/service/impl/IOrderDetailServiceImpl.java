package com.dcxuexi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dcxuexi.dao.OrderDetailDao;
import com.dcxuexi.domian.OrderDetail;
import com.dcxuexi.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @Title IOrderDetailServiceImpl
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/8 22:54
 * @Version 1.0.0
 */
@Service
public class IOrderDetailServiceImpl extends ServiceImpl<OrderDetailDao,OrderDetail> implements IOrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;


    @Override
    public List<OrderDetail> selectUserName() {
        return orderDetailDao.selectUserName();
    }
}
