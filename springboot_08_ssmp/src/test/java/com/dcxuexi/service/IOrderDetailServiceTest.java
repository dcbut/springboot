package com.dcxuexi.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dcxuexi.dao.OrderDetailDao;
import com.dcxuexi.domian.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @Title IOrderDetailServiceTest
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/9 21:16
 * @Version 1.0.0
 */
@SpringBootTest
public class IOrderDetailServiceTest {

    @Autowired
    private IOrderDetailService iOrderDetailService;


    @Test
    void testsave(){
        // 保存
        List<OrderDetail> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setUserId(112+i);
            orderDetail.setUserName("方德保险代理0"+ i);
            orderDetail.setTunnelName("北京瑞升领航0"+ i);
            orderDetail.setTunnelSn("BJRSLHKJ");
            orderDetail.setAmount(10000);
            if (i%3 ==0) {
                orderDetail.setId(378+i);
                orderDetail.setIsExecute(1);
                orderDetail.setAmount(123000);
            }
            list.add(orderDetail);
        }
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setUserId(110);
        orderDetail.setUserName("方德保险代理0");
        orderDetail.setTunnelName("北京瑞升领航0");
        orderDetail.setTunnelSn("BJRSLHKJ");
        orderDetail.setAmount(20000);
        orderDetail.setIsExecute(1);


        //boolean b = iOrderDetailService.save(orderDetail); // 保存单条记录
        //boolean b = iOrderDetailService.saveOrUpdate(orderDetail); // 保存单条记录
        //boolean b = iOrderDetailService.saveBatch(list); // 保存多条记录
        //boolean b = iOrderDetailService.saveBatch(list, 2); // 保存多条记录，每条SQL插入多少条记录
        //boolean b = iOrderDetailService.saveOrUpdate(orderDetail); // 保存或者更新记录，如果id有对应的记录 进行更新，如果没有数据则添加保存
        LambdaUpdateWrapper<OrderDetail> updateWrapper = new LambdaUpdateWrapper<OrderDetail>();
        updateWrapper.eq(OrderDetail::getUserName,"方德保险代理0");
        //boolean b = iOrderDetailService.saveOrUpdate(orderDetail, updateWrapper); // 保存或者更新记录 , 根据条件
        boolean b =iOrderDetailService.saveOrUpdateBatch(list,3); // 批量 保存或者更新记录，每条SQL处理多少条记录
        //iOrderDetailService.saveOrUpdateBatch(list); // 批量 保存或者更新记录


        System.out.println(b);

    }

    @Test
    void testupdate(){
        // 更新
        List<OrderDetail> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setUserId(123);
            orderDetail.setUserName("方德保险代理01111");
            orderDetail.setTunnelName("北京瑞升领航0111");
            orderDetail.setTunnelSn("BJRSLHKJ");
            orderDetail.setAmount(2021000);
            orderDetail.setIsExecute(1);
            orderDetail.setId(368+i);
            list.add(orderDetail);
        }

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setUserId(13);
        orderDetail.setUserName("方德保险代理01111");
        orderDetail.setTunnelName("北京瑞升领航0123");
        orderDetail.setTunnelSn("BJRSLHKJ");
        orderDetail.setAmount(1021000);
        orderDetail.setIsExecute(1);

        //boolean b = iOrderDetailService.updateById(orderDetail); // 更新 根据id 修改记录
        //boolean b = iOrderDetailService.updateBatchById(list); // 批量更新
        //boolean b = iOrderDetailService.updateBatchById(list, 2); // 批量更新 每条SQL更新 batchsize条记录
        LambdaUpdateWrapper<OrderDetail> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(OrderDetail::getUserName,"方德保险代理01111");
        updateWrapper.set(OrderDetail::getIsExecute,2);

        //boolean b = iOrderDetailService.update(orderDetail, updateWrapper); // 更新记录，根据条件
        boolean b = iOrderDetailService.update(updateWrapper); //




        //System.out.println(b);

    }

    @Test
    void testdelete(){
        // 删除
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setUserId(13);
        orderDetail.setUserName("方德保险代理01111");
        orderDetail.setTunnelName("北京瑞升领航0123");
        orderDetail.setTunnelSn("BJRSLHKJ");
        orderDetail.setAmount(1021000);
        orderDetail.setIsExecute(1);
        orderDetail.setId(367);

        List<Integer> ids = new ArrayList<>();
        ids.add(377);
        ids.add(378);
        ids.add(379);
        ids.add(380);

        Map<String,Object> map = new HashMap<>();
        map.put("user_name","方德保险代理00");
        map.put("tunnel_sn","BJRSLHKJ");
        map.put("amount",10000);
        map.put("is_execute",1);


        //boolean b = iOrderDetailService.removeById(394); // 删除，根据id删除记录 传id
        //boolean b = iOrderDetailService.removeById(orderDetail); // 删除 ，根据id删除记录  传实体类对象
        //boolean b = iOrderDetailService.removeById(369, false);
        //boolean b = iOrderDetailService.removeByIds(ids);
        //boolean b = iOrderDetailService.removeBatchByIds(ids);
        //boolean b = iOrderDetailService.removeBatchByIds(ids, 3);
        boolean b = iOrderDetailService.removeByMap(map);


        System.out.println(b);

    }

    @Test
    void testselectGet(){
        // get 查询
        LambdaQueryWrapper<OrderDetail> lqw = new LambdaQueryWrapper<>();
        lqw.like(OrderDetail::getUserName,"保险代理").last("limit 1");

        //iOrderDetailService.getById(334); // 根据id 查询
        //iOrderDetailService.getMap(lqw); // 根据条件 查询
        iOrderDetailService.getOne(lqw); // 根据条件 查询一条

    }

    @Test
    void testselectList(){
        // LIST
        List<Integer> ids = new ArrayList<>();
        ids.add(334);
        ids.add(335);
        ids.add(338);
        ids.add(337);
        Map<String,Object> map = new HashMap<>();
        map.put("user_name","方德保险代理00");
        map.put("tunnel_sn","BJRSLHKJ");
        map.put("amount",10000);
        //map.put("is_execute",1);

        LambdaQueryWrapper<OrderDetail> lqw = new LambdaQueryWrapper<>();
        lqw.last("limit 3");
        lqw.select(OrderDetail::getTunnelName);

        List<OrderDetail> list = iOrderDetailService.list(); // 查询所有记录
        //List<OrderDetail> list = iOrderDetailService.listByIds(ids); // 根据ids集合 查询记录
        //List<OrderDetail> list = iOrderDetailService.listByMap(map); // 根据 map集合 查询记录
        //List<Map<String, Object>> list = iOrderDetailService.listMaps(); //查询所有列表
        //List<Map<String, Object>> list = iOrderDetailService.listMaps(lqw);// 根据条件  查询 列表
        //List<Object> list = iOrderDetailService.listObjs(lqw);

        list.forEach(System.out::println);

    }

    @Test
    void testselectPage(){
        // 分页
        LambdaQueryWrapper<OrderDetail> lqw = new LambdaQueryWrapper<>();
        lqw.likeRight(OrderDetail::getTunnelName,"安徽梦谷");


        IPage<OrderDetail> iPage = new Page<>(1,5);
        iPage = iOrderDetailService.page(iPage,lqw);
        System.out.println(iPage.getRecords());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getPages());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getCurrent());

    }

    @Test
    void testcount(){
        // 计数
        LambdaQueryWrapper<OrderDetail> lqw = new LambdaQueryWrapper<>();
        lqw.likeRight(OrderDetail::getTunnelName,"安徽梦谷");
        //long count = iOrderDetailService.count();
        long count = iOrderDetailService.count(lqw);
        System.out.println(count);

    }

    @Test
    void testselectUserName(){
        List<OrderDetail> list = iOrderDetailService.selectUserName();
        list.forEach(System.out::println);


    }






}
