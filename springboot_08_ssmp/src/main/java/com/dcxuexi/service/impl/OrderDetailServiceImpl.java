package com.dcxuexi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dcxuexi.dao.OrderDetailDao;
import com.dcxuexi.domian.OrderDetail;
import com.dcxuexi.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/***
 * @Title OrderDetailServiceImpl
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/28 18:33
 * @Version 1.0.0
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;


    @Override
    public OrderDetail selectById(Integer id) {
        OrderDetail orderDetail = orderDetailDao.selectById(id);
        return orderDetail;
    }

    @Override
    public List<OrderDetail> selectByMap(Map<String, Object> map) {
        List<OrderDetail> orderDetails = orderDetailDao.selectByMap(map);
        return orderDetails;
    }

    @Override
    public boolean save(OrderDetail orderDetail) {
        return orderDetailDao.insert(orderDetail) > 0;
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        return orderDetailDao.updateById(orderDetail) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return orderDetailDao.deleteById(id) > 0;
    }

    @Override
    public IPage<OrderDetail> selectPage(Integer current,Integer size) {
        IPage<OrderDetail> iPage = new Page<>(current,size);
        orderDetailDao.selectPage(iPage,null);
        return iPage;
    }

    @Override
    public List<OrderDetail> selectAll() {
        return orderDetailDao.selectList(null);
    }
}
