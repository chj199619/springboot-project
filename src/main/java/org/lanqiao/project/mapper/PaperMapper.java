package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.lanqiao.project.pojo.Cond;
import org.lanqiao.project.pojo.Paper;
import org.lanqiao.project.pojo.psCar;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PaperMapper {
    //查所有
    @Select("select * from paper")
    public List<Paper> findAll();
    //删除
    @Delete("delete from paper where id=#{id}")
    public void deletePaper(Integer id);
    //查一个
    @Select("select * from paper where id = #{id}")
    public Paper findById(Integer id);
    @Select("select * from paper where ddid = #{ddid}")
    public Paper findByOne(Integer ddid);
    @Select("select * from paper where ddid like CONCAT('%',#{ddid},'%')")
    public List<Paper> findByDdid(Integer ddid);
    //查condition
    @Select("select * from paper where pscondition = #{condition}")
    public  List<Paper> fingBycondition(String condition);
    //改状态
    @Update("update paper set pscondition=#{pscondition} where id = #{id}")
    public void update(Paper paper);
    @Select("select * from cond")
    public List<Cond> conds();
    @Select("select * from car where p_id=#{pid} and u_id=#{uid}")
    public List<psCar> details(int pid, int uid);
}
