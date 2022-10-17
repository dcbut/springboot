package com.dcxuexi.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dcxuexi.domian.OrderDetail;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;

/***
 * @Title OrderDetailTest
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/28 18:18
 * @Version 1.0.0
 */
@SpringBootTest
public class OrderDetailTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    void test(){
//        orderDetailDao.selectById(); // 根据id 查询结果
//        orderDetailDao.selectByMap(); // 根据查询字段条件 查询结果
//        orderDetailDao.selectMapsPage();
//        orderDetailDao.selectMaps(),  //根据 Wrapper 条件，查询全部记录 @param queryWrapper 实体对象封装操作类（可以为 null）
//        orderDetailDao.selectCount();  //根据 Wrapper 条件，查询总记录数 @param queryWrapper 实体对象封装操作类（可以为 null）
//        orderDetailDao.selectBatchIds();
//        orderDetailDao.selectList();
//        orderDetailDao.selectPage();
//        orderDetailDao.selectObjs();
//        orderDetailDao.selectOne();  // 根据 entity 条件，查询一条记录
    }

    @Test
    void testselectById() {
        final OrderDetail orderDetail = orderDetailDao.selectById(337);  // 根据id 查询结果
        System.out.println(orderDetail);
    }

    @Test
    void  testselectByMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user_id",1);
        map.put("tunnel_sn","AHMENGGU");
        List<OrderDetail> orderDetails = orderDetailDao.selectByMap(map); // 根据查询字段条件 查询结果
        System.out.println(orderDetails);

    }

    @Test
    void testselectMapsPage(){



    }

    @Test
    void testselectMaps(){
        QueryWrapper<OrderDetail> orderDetailWrapper = Wrappers.query();
        orderDetailWrapper.select("id","user_name","tunnel_name","amount","start_time","is_execute")
                .like("tunnel_name","梦谷");
        List<Map<String, Object>> maps = orderDetailDao.selectMaps(orderDetailWrapper);
        maps.forEach(System.out::println);
        List<OrderDetail> orderDetailList =new ArrayList<>();
        for (int i = 0; i < maps.size(); i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId((Integer) maps.get(i).get("id"));
            orderDetail.setUserName((String) maps.get(i).get("user_name"));
            orderDetail.setAmount((Integer) maps.get(i).get("amount"));
            orderDetail.setTunnelName((String) maps.get(i).get("tunnel_name"));
            orderDetail.setIsExecute((Integer) maps.get(i).get("is_execute"));
            orderDetail.setStartTime(new SimpleDateFormat("yyyy-MM-dd").format(maps.get(i).get("start_time")));
            orderDetailList.add(orderDetail);
        }
        orderDetailList.forEach(System.out::println);
    }

    @Test
    void testselectCount(){
        QueryWrapper<OrderDetail> orderDetailWrapper = Wrappers.query();
        orderDetailWrapper.ge("amount",1000000);
        Integer count = Math.toIntExact(orderDetailDao.selectCount(orderDetailWrapper));
        System.out.println(count);


    }

    @Test
    void testselectBatchIds(){}

    @Test
    void testselectList(){
        QueryWrapper<OrderDetail> orderDetailQueryWrapper = new QueryWrapper<>();
        orderDetailQueryWrapper.like("tunnel_name","梦谷");
        orderDetailDao.selectList(orderDetailQueryWrapper);

    }

    @Test
    void testselectList2(){
        String tunnelName = "科技";
        LambdaQueryWrapper<OrderDetail> lqw = new LambdaQueryWrapper<OrderDetail>();
        lqw.like(StringUtils.isNotEmpty(tunnelName),OrderDetail::getTunnelName,tunnelName);
        orderDetailDao.selectList(lqw);

    }




    @Test
    void testGetPage(){
        String tunnelName = "科技";
        LambdaQueryWrapper<OrderDetail> lqw = new LambdaQueryWrapper<OrderDetail>();
        lqw.like(StringUtils.isNotEmpty(tunnelName),OrderDetail::getTunnelName,tunnelName);
        IPage<OrderDetail> page = new Page<>(2,5);
        orderDetailDao.selectPage(page, lqw);
        System.out.println(page.getCurrent()); // 当前页
        System.out.println(page.getSize()); // 每页几条记录
        System.out.println(page.getPages());//  总共多少页
        System.out.println(page.getTotal()); // 总共多少条记录
        System.out.println(page.getRecords()); // 当前页记录
        System.out.println(page.getRecords().get(0).toString()); // 当前页记录
    }

    @Test
    void testselectObjs(){}

    @Test
    void testselectOne(){
        QueryWrapper<OrderDetail> orderDetailQueryWrapper = Wrappers.query();
        orderDetailQueryWrapper.eq("amount",3256872);
        OrderDetail orderDetail = orderDetailDao.selectOne(orderDetailQueryWrapper);
        System.out.println(orderDetail);
    }


    @Test
    void  testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setUserId(1);
        orderDetail.setUserName("方德保险代理");
        orderDetail.setTunnelName("北京瑞升领航");
        orderDetail.setTunnelSn("BJRSLHKJ");
        orderDetail.setAmount(10000);
        int i = orderDetailDao.insert(orderDetail);
        System.out.println(i);

    }
    @Test
    void  testUpdate(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(365);
        orderDetail.setIsExecute(1);


        int i = orderDetailDao.updateById(orderDetail);
        System.out.println(i);

    }
    @Test
    void  testDelete(){

        int i = orderDetailDao.deleteById(365);
        System.out.println(i);

    }

    @Test
    void testDeleteIds(){
        Collection<Integer> ids = new ArrayList<>();
        ids.add(361);
        ids.add(362);
        ids.add(363);
        ids.add(364);
        int i = orderDetailDao.deleteBatchIds(ids);
        System.out.println(i);

    }

    @Test
    void  testselectUserName(){
        List<OrderDetail> list = orderDetailDao.selectUserName();
        list.forEach(System.out::println);
    }




}
