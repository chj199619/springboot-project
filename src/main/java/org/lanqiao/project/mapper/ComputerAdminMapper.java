package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.project.pojo.Goodscomput;
import org.lanqiao.project.pojo.Condition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ComputerAdminMapper {
    //分页
    public int getComputerCount(Condition condition);
    public List<Goodscomput> getAll(Condition condition);
    //根据商品id查商品详请
    @Select("select * from goodscomput where g_id=#{g_id}")
    public Goodscomput selectGooodsComputById(@Param("g_id")int g_id);
    //修改库存
    @Update("update goodscomput set g_num = #{g_num} where g_id = #{g_id}")
    public void updateKucun(@Param("g_num")int g_num,@Param("g_id")int g_id);
    //修改单价
    public void updatePrice(@Param("g_price")double g_price,@Param("g_oriprice") double g_oriprice,@Param("g_id")int g_id);
    //上架商品
    @Insert("insert into goodscomput (g_img,g_name,g_xiangqing,g_price,g_oriprice,g_color,t_type,g_neicun,g_hiredate,g_num) values (#{g_img},#{g_name},#{g_xiangqing},#{g_price},#{g_oriprice},#{g_color},#{t_type},#{g_neicun},#{g_hiredate},#{g_num})")
    public void insertAddComput(Goodscomput goodscomput);
    //删除
    public void deletegoodscomput(int g_id);
}
