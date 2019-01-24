package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import org.lanqiao.project.pojo.PsPaper;
import org.lanqiao.project.pojo.User;
import org.lanqiao.project.pojo.psCar;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PsPaperMapper {
    //查所有
    @Select("select * from paper")
    public List<PsPaper> findAll();
    //删除
    @Delete("delete from paper where id=#{id}")
    public void deletePaper(Integer id);
    //查一个
    @Select("select * from paper where id = #{id}")
    public PsPaper findById(Integer id);
    @Select("select * from paper where ddid = #{ddid}")
    public PsPaper findByOne(Integer ddid);
    @Select("select * from paper where ddid like CONCAT('%',#{ddid},'%')")
    public List<PsPaper> findByDdid(Integer ddid);
    //查condition
    @Select("select * from paper where pscondition = #{condition}")
    public  List<PsPaper> fingBycondition(String condition);
    //改状态
    @Update("update paper set pscondition=#{pscondition} where id = #{id}")
    public void update(PsPaper paper);

    @Select("select * from car where p_id=#{pid} and u_id=#{uid}")
    public List<psCar> details(int pid, int uid);
    @Select("select * from user where u_id = #{u_id}")
    public User user(int u_id);
}
