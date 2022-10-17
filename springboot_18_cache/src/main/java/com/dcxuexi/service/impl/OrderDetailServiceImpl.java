package com.dcxuexi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dcxuexi.dao.OrderDetailDao;
import com.dcxuexi.domain.OrderDetail;
import com.dcxuexi.service.OrderDetailService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @Title OrderDetailServiceImpl
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/10/3 20:45
 * @Version 1.0.0
 */
@Service
public class OrderDetailServiceImpl  extends ServiceImpl<OrderDetailDao, OrderDetail>  implements OrderDetailService {
    @Override
    public List<OrderDetail> selectUserName() {
        return null;
    }

    @Override
    @Cacheable(value = "cacheSpce",key = "#id")
    public OrderDetail getById(Integer id) {
        return super.getById(id);
    }

}
