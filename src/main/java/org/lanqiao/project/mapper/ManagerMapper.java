package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.project.pojo.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerMapper {
    //登陆
    @Select("select * from manager where username=#{username}")
    public Manager selectUsername(String username);
    //管理员表
    @Select("select * from manager")
    public List<Manager> selectAll();
    //删除
    @Delete("delete from manager where id=#{id}")
    public void deleteUser(int id);


}
