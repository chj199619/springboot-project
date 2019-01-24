package org.lanqiao.project.service;

import org.lanqiao.project.mapper.NewGoodsMapper;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Goodscomputnew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewGoodsService implements NewGoodsMapper{
    @Autowired
    NewGoodsMapper newGoodsMapper;

    @Override
    public int getComputerCount(Condition condition) {
        return newGoodsMapper.getComputerCount(condition);
    }

    @Override
    public List<Goodscomputnew> getAll(Condition condition) {
        List<Goodscomputnew> goodscomputnewList=newGoodsMapper.getAll(condition);
        return goodscomputnewList;
    }

    @Override
    public Goodscomputnew selectGooodsComputById(int g_id) {

        return newGoodsMapper.selectGooodsComputById(g_id);
    }

    @Override
    public void updateKucun(int g_num, int g_id) {
            newGoodsMapper.updateKucun(g_num,g_id);
    }

    @Override
    public void updatePrice(double g_price, double g_oriprice, int g_id) {
            newGoodsMapper.updatePrice(g_price,g_oriprice,g_id);
    }

    @Override
    public void insertAddComput(Goodscomputnew goodscomputnew) {
        newGoodsMapper.insertAddComput(goodscomputnew);

    }

    @Override
    public void deletegoodscomput(int g_id) {
        newGoodsMapper.deletegoodscomput(g_id);

    }
}
