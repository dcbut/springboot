package com.dcxuexi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dcxuexi.domian.OrderDetail;

import java.util.List;
import java.util.Map;

/***
 * @Title OrderDetailService
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/28 18:32
 * @Version 1.0.0
 */

public interface OrderDetailService {

    OrderDetail selectById(Integer id); //  根据id 查询结果

    List<OrderDetail> selectByMap(Map<String,Object> map); //  根据查询字段条件 查询结果

    boolean save(OrderDetail orderDetail);

    boolean update(OrderDetail orderDetail);
    boolean delete(Integer id);
    IPage<OrderDetail> selectPage(Integer current,Integer size);
    List<OrderDetail> selectAll();










}
