package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.*;

import org.lanqiao.project.pojo.PsPaper;
import org.lanqiao.project.pojo.CUser;
import org.lanqiao.project.pojo.psCar;

import java.util.List;

@Mapper
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
    public  List<PsPaper> fingBycondition(@Param("condition") String condition);
    //改状态
    @Update("update paper set pscondition=#{pscondition} where id = #{id}")
    public void update(@Param("pscondition") String pscondition,@Param("id") int id);
    @Update("update car set cond = #{cond} where u_id = #{u_id} and p_id=#{p_id}")
    public void UpdateCar(@Param("cond") String cond,@Param("u_id")int u_id,@Param("p_id") int p_id);
//    @Select("select * from cond")
//    public List<Cond> conds();

    @Select("select * from car where p_id= #{p_id} and u_id=#{u_id} and cond = #{cond}")
    public List<psCar> details(psCar car);
    @Select("select * from user where u_id = #{u_id}")
    public CUser user(int u_id);
}
