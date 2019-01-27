package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.project.pojo.CUser;
import org.lanqiao.project.pojo.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user")
    public List<User>selectAll1();
    @Select("select * from user where u_name=#{u_name}")
    public User selectUser1(@Param("u_name")String u_name) throws SQLException;
    //    String u_name, String u_password, String u_nickname, String u_phone, String u_email, Date u_hiredate
    @Insert("insert into user(u_name,u_password,u_nickname,u_phone,u_email,u_hiredate)values(#{u_name},#{u_password},#{u_nickname},#{u_phone},#{u_email},#{u_hiredate})")
    public void addUser(User user);
}

