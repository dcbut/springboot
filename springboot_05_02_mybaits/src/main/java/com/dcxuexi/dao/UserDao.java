package com.dcxuexi.dao;

import com.dcxuexi.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * @Title UserDao
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/22 21:07
 * @Version 1.0.0
 */
@Mapper
@Repository
public interface UserDao {

    @Select("select user_id userId, email,user_name userName,branch_name branchName from platform_user where user_id = #{userId}")
    public List<User> getById(Integer userId);
}
