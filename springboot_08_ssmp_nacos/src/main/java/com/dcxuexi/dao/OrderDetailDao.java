package com.dcxuexi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dcxuexi.domian.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * @Title OrderDetailDao
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/28 18:09
 * @Version 1.0.0
 */
@Mapper
@Repository
public interface OrderDetailDao extends BaseMapper<OrderDetail> {


//    @Select("SELECT id,user_name userName,user_id userId,tunnel_name tunnelName,tunnel_sn tunnelSn,amount,start_time startTime,yddingdan,ltdingdan,g,successnum,is_execute isExecute,exec_time execTime FROM order_detail WHERE id = #{id}")
//    @Select("SELECT * FROM order_detail WHERE id = #{id}")
//    OrderDetail getInfoOrderDetailById(Integer id);

    List<OrderDetail> selectUserName();




}
