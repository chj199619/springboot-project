package org.lanqiao.project.service;

import org.lanqiao.project.pojo.CDT;
import org.lanqiao.project.pojo.Computer;
import org.lanqiao.project.pojo.Goods;
import org.lanqiao.project.pojo.Jianpan;

import java.util.List;

public interface IGoodsService {

    public List<Goods> findAllgoods();
    public List<Goods> findNewgoods();
    public List<Goods> findShangoods();
    //首页遍历
    public List<Computer> findsyComgoods();
    public List<Computer> findsyYXComgoods();
    public List<Jianpan> findJsyPgoods();
    //全部遍历
    public List<Computer> findComgoods(CDT condition);
    public List<Computer> findYXComgoods(CDT condition);
    public List<Jianpan> findJPgoods();
    //商品详情遍历
    public List<Computer> findCombyid(int id);
    public List<Computer> findYXCombyid(int id);
}
