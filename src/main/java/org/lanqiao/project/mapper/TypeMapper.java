package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Type;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TypeMapper {
    //分页
    public int getTypeCount(Condition condition);
    public List<Type> getAll(Condition condition);
    //shanchu
    public void deleteType(int id);
    @Select("select * from type where id=#{id}")
    public Type selectTypeByid(int id);
//    @Update("update type set zhuangtai = #{zhuangtai} where id = #{id}")

    public void updateRate(String zhuangtai,String x_time,int id);
    public void updateRate2(String zhuangtai,String s_time,int id);
    public void updateRate3(String zhuangtai,String s_time,String x_time,int id);

    @Insert("insert into type (t_type,zhuangtai,s_time) values (#{t_type},#{zhuangtai},#{s_time})")
    public void insertType(Type type);
    @Select("select count(1) from  goodscomput")
    public int getGoodscomputnum();
    @Select("select count(1) from  goodscomputer")
    public int getGoodscomputernum();
    @Select("select count(1) from  goods")
    public int getGoodscomputernum1();

}
