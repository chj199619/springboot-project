package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Rate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RateadminMapper {
    //分页
    public int getRateCount(Condition condition);
    public List<Rate> getAll(Condition condition);
    //shanchu
    public void deleteRate(int rate_id);
    @Select("select * from rate where rate_id=#{rate_id}")
    public Rate selectRateByid(@Param("rate_id")int rate_id);
    @Update("update rate set answernews = #{answernews} where rate_id = #{rate_id}")
    public void updateRate(@Param("answernews") String answernews,@Param("rate_id") int rate_id);

}
