package org.lanqiao.project.service;

import org.lanqiao.project.mapper.GoodsMapper;
import org.lanqiao.project.pojo.CDT;
import org.lanqiao.project.pojo.Computer;
import org.lanqiao.project.pojo.Goods;
import org.lanqiao.project.pojo.Jianpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceimpl implements IGoodsService {
    @Autowired
    GoodsMapper goodsMapper;


    @Override
    public List<Goods> findAllgoods() {
        List<Goods> goodsList = goodsMapper.selectAllgoods();
        return goodsList;
    }

    @Override
    public List<Goods> findNewgoods() {
        List<Goods> goodsList = goodsMapper.selectNewgoods();
        return goodsList;
    }

    @Override
    public List<Goods> findShangoods() {
        List<Goods> goodsList = goodsMapper.selectShangoods();
        return goodsList;
    }

    @Override
    public List<Computer> findsyComgoods() {
        List<Computer> computerList = goodsMapper.selectComINsy();
        return computerList;
    }

    @Override
    public List<Computer> findsyYXComgoods() {
        List<Computer> computerList = goodsMapper.selectComYXsy();
        return computerList;
    }

    @Override
    public List<Jianpan> findJsyPgoods() {
        List<Jianpan> jianpanList = goodsMapper.selectJPsy();
        return jianpanList;
    }

    @Override
    public List<Computer> findComgoods(CDT condition) {

        List<Computer> comList = goodsMapper.selectComIN(condition);
        return comList;
    }

    @Override
    public List<Computer> findYXComgoods(CDT condition) {
        List<Computer> computerList = goodsMapper.selectComYX(condition);
        return computerList;
    }

    @Override
    public List<Jianpan> findJPgoods() {
        List<Jianpan> jianpanList = goodsMapper.selectJP();
        return jianpanList;
    }

    @Override
    public List<Computer> findCombyid(int id) {
        List<Computer> computerList = goodsMapper.selectCombyid(id);
        return computerList;
    }

    @Override
    public List<Computer> findYXCombyid(int id) {
        List<Computer> computerList = goodsMapper.selectYXCombyid(id);
        return computerList;
    }
}
