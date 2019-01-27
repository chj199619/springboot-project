package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.*;
import org.lanqiao.project.pojo.Cart;
import org.lanqiao.project.pojo.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {
    //    购物车数量
    @Select("select * from car")
    public List<Cart> selectAllCart();
    @Select("select * from car where u_id=#{u_id} and p_id=#{p_id}")
    public List<Cart> selectAll(@Param("u_id")int u_id,@Param("p_id")int p_id);

    @Select("select * from wish where u_id=#{u_id}")
    public List<Cart> selectWish(@Param("u_id") int u_id);

    @Select("select * from car where g_id=#{gid}  and u_id=#{uid}")
    public Cart selectCartById(@Param("gid") int gid,@Param("uid") int uid);

    @Insert("INSERT INTO car (g_id,g_img,g_name,g_color,g_price,c_num,u_id,p_id) VALUES (#{g_id},#{g_img},#{g_name},#{g_color},#{g_price},#{c_num},#{u_id},#{p_id})")
    public void add(Cart cart);

    @Insert("INSERT INTO wish (g_id,g_img,g_name,g_color,c_price,c_num,u_id,p_id) VALUES (#{g_id},#{g_img},#{g_name},#{g_color},#{c_price},#{c_num},#{u_id},,#{p_id})")
    public void house(Cart cart);



    @Update("UPDATE car SET c_num = #{num} WHERE g_id = #{id}")
    public void upnum(@Param("num") int num, @Param("id") int id);

    @Delete("Delete from car  WHERE g_id = #{gid} AND u_id = #{u_id}")
    public void  del(@Param("gid") int gid, @Param("u_id") int u_id);

    @Delete("Delete from wish  WHERE g_id = #{id}")
    public void delWish(@Param("gid") int gid, @Param("u_id") int u_id);


    @Insert("insert into paper(ddid,name,lastp,kuaidi,pscondition,u_id)values (#{ddid},#{name},#{lastp},#{kuaidi},#{pscondition},#{uid})")
    public void psaddPaper(Paper paper);

    @Update("UPDATE car SET p_id = #{p_id} WHERE u_id = #{id}")
    public void uppid(@Param("p_id") int p_id, @Param("id") int id);

    //当确定付款时 insert购物车中pid为new date
    @Update("update car set p_id = #{pid} ,cond=#{cond} where u_id = #{uid}")
    public void pansUpdate(@Param("pid") int pid,@Param("cond") String cond, @Param("uid") int uid);

    @Select("select u_address from user where u_id=#{uid}")
    public String  selectUserAddress(@Param("uid") int uid);
}
