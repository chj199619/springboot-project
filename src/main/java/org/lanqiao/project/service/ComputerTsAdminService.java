package org.lanqiao.project.service;

import org.lanqiao.project.mapper.ComputerTsAdminMapper;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Goodscomput;
import org.lanqiao.project.pojo.Goodscomputer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComputerTsAdminService implements ComputerTsAdminMapper {
    @Autowired
    ComputerTsAdminMapper computerTsAdminMapper;
    @Override
    public int getComputerTsCount(Condition condition) {
        return computerTsAdminMapper.getComputerTsCount(condition);
    }

    @Override
    public List<Goodscomputer> getAll(Condition condition) {
        List<Goodscomputer> goodscomputerList=computerTsAdminMapper.getAll(condition);
        return goodscomputerList;
    }

    @Override
    public Goodscomput selectGooodsComputerById(int g_id) {
        return computerTsAdminMapper.selectGooodsComputerById(g_id);
    }

    @Override
    public void updateTsKucun(int g_num, int g_id) {
        computerTsAdminMapper.updateTsKucun(g_num,g_id);

    }

    @Override
    public void updateTsPrice(double g_price, double g_oriprice, int g_id) {
        computerTsAdminMapper.updateTsPrice(g_price,g_oriprice,g_id);

    }

    @Override
    public void insertAddComputer(Goodscomputer goodscomputer) {
        computerTsAdminMapper.insertAddComputer(goodscomputer);

    }

    @Override
    public void deleteTsComputer(int g_id) {
        computerTsAdminMapper.deleteTsComputer(g_id);
    }
}
