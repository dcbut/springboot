package com.dcxuexi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dcxuexi.domain.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/***
 * @Title OrderDetailDao
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/10/3 20:41
 * @Version 1.0.0
 */
@Mapper
@Repository
public interface OrderDetailDao extends BaseMapper<OrderDetail> {
}
