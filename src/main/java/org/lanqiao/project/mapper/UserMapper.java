package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.*;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository("UserMapper")
@Component
public interface UserMapper {
    @Select("select * from user")
    public List<User>selectAll();
    @Select("select * from user where u_id=#{u_id}")
    public User selectUserById(int u_id);
    //新增
    @Insert("insert into user (u_name,u_password,u_nickname,u_phone,u_email,u_hiredate,province,city,area,u_address) values (#{u_name},#{u_password},#{u_nickname},#{u_phone},#{u_email},#{u_hiredate},#{province},#{city},#{area},#{u_address})")
    public void insertUser(User user);
    //修改
    @Update("update user set u_password = #{u_password} where u_id = #{u_id}")
    public void updateUser(String u_password,int u_id);

    //删除
    public void deleteUser(int u_id);
    //分页
    //获取员工总数
    public int getUserCount(Condition condition);
    //获取user列表
    public List<User> getAll(Condition condition);



}

