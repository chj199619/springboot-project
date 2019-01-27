package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.project.pojo.YLCar;
import org.lanqiao.project.pojo.YLPaper;
import org.lanqiao.project.pojo.YLPerson;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface YLMapper {
    @Select("select * from car where u_id=#{param1} and p_id=#{param2}")
    public List<YLCar>  ylgetAll(int u_id, int p_id);

    @Select ("select * from paper where pscondition=#{param1}")
    public List<YLPaper> lgetAll(String cond);

    @Select("select * from car")
    public List<YLCar> getAllCar();

    @Select("select * from car where g_id=#{g_id}")
    public List<YLCar> getListByid(int id);

    @Insert("insert into paper(ddid,name,lastp,kuaidi,pscondition,u_id,adress) values(#{ddid},#{name},#{lastp},#{kuaidi},#{pscondition},#{u_id},#{adress})")
    public void addPaper(YLPaper paper);
    //user
    @Select("select * from user where u_id=#{u_id}")
    public YLPerson getUserById(int id);

    @Update("update user set u_name=#{u_name},u_password=#{u_password},u_nickname=#{u_nickname},u_phone=#{u_phone},u_email=#{u_email},u_hiredate=#{u_hiredate},u_address=#{u_address} where u_id=#{u_id}")
    public void getUpdate(YLPerson ylPerson);

    @Update("update car set p_id = #{param1} where u_id = #{param2}")
    public void yulongUpdate(int p_id, int u_id);
    @Update("update car set cond = #{cond} where u_id = #{u_id} and p_id=#{p_id}")
    public void ylUpdateCar(YLCar Car);

    @Select("select * from car where u_id=#{param1} and cond=#{param2}")
    public List<YLCar> carWei(int u_id, String cond);
    @Select("select * from car where u_id=#{u_id}")
    public List<YLCar> sAll(int u_id);
//    确认收货后更新
    @Select("select * from car where g_id=#{g_id}")
    public YLCar yselect(int g_id);
    @Update("update car set cond=#{cond} where u_id=#{u_id}")
    public void yUpdate(YLCar car);


}
