package com.dcxuexi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dcxuexi.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/***
 * @Title UserDao
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/22 22:15
 * @Version 1.0.0
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {
//    @Select("select user_id userId, email,user_name userName,branch_name branchName from platform_user where user_id = #{userId}")
//    public User getById(Integer userId);
}
