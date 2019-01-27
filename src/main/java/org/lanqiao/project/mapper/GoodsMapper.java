package org.lanqiao.project.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.project.pojo.CDT;
import org.lanqiao.project.pojo.Computer;
import org.lanqiao.project.pojo.Goods;
import org.lanqiao.project.pojo.Jianpan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    //热卖遍历
    @Select("select * from goods")
    public List<Goods> selectAllgoods();
    //新品遍历
    @Select("select * from newgoods")
    public List<Goods> selectNewgoods();
    //闪购遍历
    @Select("select * from goodscomput")
    public List<Goods> selectShangoods();
    //首页电脑整机遍历
    @Select("select * from goodscomputer limit 0,5")
    public List<Computer> selectComINsy();
    //全部电脑整机遍历
    public List<Computer> selectComIN(CDT condition);
    //首页游戏本遍历
    @Select("select * from goodscomputeryx limit 0,5")
    public List<Computer> selectComYXsy();
    //全部游戏本遍历

    public List<Computer> selectComYX(CDT condition);
    //首页键盘遍历
    @Select("select * from goodsjianpan limit 0,5")
    public List<Jianpan> selectJPsy();
    //全部键盘遍历
    @Select("select * from goodsjianpan ")
    public List<Jianpan> selectJP();
    @Select("select * from goodscomputer where g_id=#{id}")
    public List<Computer> selectCombyid(@Param("id") int id);
    @Select("select * from goodscomputeryx where g_id=#{id}")
    public List<Computer> selectYXCombyid(@Param("id") int id);
}
