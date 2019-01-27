package org.lanqiao.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.project.pojo.YLRate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface YLRateMapper {
    @Insert("insert into rate (g_id,u_id,g_name,news) values (#{g_id},#{u_id},#{g_name},#{r_news})")
    public void insertRate(YLRate ylRate);
}
