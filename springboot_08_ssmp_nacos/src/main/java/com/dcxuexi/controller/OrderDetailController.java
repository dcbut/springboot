package com.dcxuexi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dcxuexi.dao.R;
import com.dcxuexi.domian.OrderDetail;
import com.dcxuexi.service.IOrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * @Title OrderDetailController
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/10 19:28
 * @Version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {

    @Autowired
    private IOrderDetailService iOrderDetailService;

    // 查询 所有记录
    @GetMapping
    public R getAllList(){
        return new R(true,iOrderDetailService.list());
    }

    // 添加
    @PostMapping
    public R save(@RequestBody OrderDetail orderDetail ){
        return new R(iOrderDetailService.save(orderDetail));
    }

    //更新
    @PutMapping
    public R update(@RequestBody OrderDetail orderDetail){
        return new R(iOrderDetailService.updateById(orderDetail)) ;
    }

    // 删除
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(iOrderDetailService.removeById(id)) ;
    }

    // 查询详情
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,iOrderDetailService.getById(id)) ;
    }

    // 分页查询
    @GetMapping("/{current}/{size}")
    public R getPage(@PathVariable Integer current, @PathVariable Integer size){
        Page<OrderDetail> page = iOrderDetailService.page(new Page<OrderDetail>(current, size));

        log.info(String.valueOf(page.getCurrent()));
        log.info(String.valueOf(page.getPages()));
        log.info(String.valueOf(page.getSize()));
        log.info(String.valueOf(page.getTotal()));
        log.info(String.valueOf(page.getRecords()));
        return new R(true,page);
    }




}
