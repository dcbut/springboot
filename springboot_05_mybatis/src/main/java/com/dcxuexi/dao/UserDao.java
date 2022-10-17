package com.dcxuexi.dao;

import com.dcxuexi.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/***
 * @Title UserDao
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/22 20:25
 * @Version 1.0.0
 */
@Mapper
@Repository
public interface UserDao {


    @Select("select user_id userId, email,user_name userName,branch_name branchName from platform_user where user_id = #{id}")
    public User getById(Integer id);


}
