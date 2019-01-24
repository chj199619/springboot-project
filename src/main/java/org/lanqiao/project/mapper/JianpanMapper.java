package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Goodscomput;
import org.lanqiao.project.pojo.Goodsjianpan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface JianpanMapper {
    //分页
    public int getJianpanCount(Condition condition);
    public List<Goodsjianpan> getAll(Condition condition);
    //根据商品id查商品详请
    @Select("select * from goodsjianpan where id=#{id}")
    public Goodsjianpan selectGooodsJianpanById(int id);
    //修改库存
    @Update("update goodsjianpan set jnum = #{jnum} where id = #{id}")
    public void updateKucun(int jnum,int id);
    //修改单价
    public void updatePrice(double jlastprice,double jorgprice,int id);
    //上架商品
    @Insert("insert into goodsjianpan (jpicture,jname,jlastprice,jorgprice,t_type,jhiredate,jnum) values (#{jpicture},#{jname},#{jlastprice},#{jorgprice},#{t_type},#{jhiredate},#{jnum})")
    public void insertAddjian(Goodsjianpan goodsjianpan);
    //删除
    public void deletegoodsjian(int id);
}
