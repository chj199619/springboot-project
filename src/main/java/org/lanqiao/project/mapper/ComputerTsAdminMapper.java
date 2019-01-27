package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Goodscomput;
import org.lanqiao.project.pojo.Goodscomputer;

import java.util.List;

public interface ComputerTsAdminMapper {
    //分页
    public int getComputerTsCount(Condition condition);
    public List<Goodscomputer> getAll(Condition condition);
    @Select("select * from goodscomputer where g_id=#{g_id}")
    public Goodscomput selectGooodsComputerById(@Param("g_id")int g_id);
    //修改库存
    @Update("update goodscomputer set g_num = #{g_num} where g_id = #{g_id}")
    public void updateTsKucun(@Param("g_num") int g_num,@Param("g_id") int g_id);
    //修改单价
    public void updateTsPrice(@Param("g_price")double g_price,@Param("g_oriprice")double g_oriprice,@Param("g_id")int g_id);
    //上架商品
    @Insert("insert into goodscomputer (g_img,g_name,g_xiangqing,g_price,g_oriprice,g_color,t_type,g_neicun,g_hiredate,g_num) values (#{g_img},#{g_name},#{g_xiangqing},#{g_price},#{g_oriprice},#{g_color},#{t_type},#{g_neicun},#{g_hiredate},#{g_num})")
    public void insertAddComputer(Goodscomputer goodscomputer);
    //删除
    public void deleteTsComputer(@Param("g_id")int g_id);
}
