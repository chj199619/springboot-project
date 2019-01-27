package org.lanqiao.project.service;

import org.lanqiao.project.mapper.ComputerAdminMapper;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Goodscomput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComputerAdminService implements ComputerAdminMapper {
    @Autowired
    ComputerAdminMapper computerAdminMapper;
    @Override
    public int getComputerCount(Condition condition) {
        return computerAdminMapper.getComputerCount(condition);
    }

    @Override
    public List<Goodscomput> getAll(Condition condition) {
        List<Goodscomput> goodscomputList=computerAdminMapper.getAll(condition);
        return goodscomputList;
    }

    @Override
    public Goodscomput selectGooodsComputById(int g_id) {
        return computerAdminMapper.selectGooodsComputById(g_id);
    }

    @Override
    public void updateKucun(int g_num, int g_id) {
        computerAdminMapper.updateKucun(g_num,g_id);
    }

    @Override
    public void updatePrice(double g_price, double g_oriprice, int g_id) {
        computerAdminMapper.updatePrice(g_price, g_oriprice, g_id);

    }

    @Override
    public void insertAddComput(Goodscomput goodscomput) {
        computerAdminMapper.insertAddComput(goodscomput);
    }

    @Override
    public void deletegoodscomput(int g_id) {
        computerAdminMapper.deletegoodscomput(g_id);
    }
}
