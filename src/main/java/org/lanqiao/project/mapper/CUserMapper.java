package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.*;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.CUser;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CUserMapper {
    @Select("select * from user")
    public List<CUser>selectAll();
    @Select("select * from user where u_id=#{u_id}")
    public CUser selectUserById(@Param("u_id")int u_id);
    //新增
    @Insert("insert into user (u_name,u_password,u_nickname,u_phone,u_email,u_hiredate,province,city,area,u_address) values (#{u_name},#{u_password},#{u_nickname},#{u_phone},#{u_email},#{u_hiredate},#{province},#{city},#{area},#{u_address})")
    public void insertUser(CUser user);
    //修改
    @Update("update user set u_password = #{u_password} where u_id = #{u_id}")
    public void updateUser(@Param("u_password")String u_password,@Param("u_id")int u_id);
    //删除
    public void deleteUser(int u_id);
    //分页
    //获取员工总数
    public int getUserCount(Condition condition);
    //获取user列表
    public List<CUser> getAll(Condition condition);



}

