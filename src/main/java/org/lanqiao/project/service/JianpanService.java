package org.lanqiao.project.service;

import org.lanqiao.project.mapper.JianpanMapper;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Goodsjianpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JianpanService implements JianpanMapper {
    @Autowired
    JianpanMapper jianpanMapper;

    @Override
    public int getJianpanCount(Condition condition) {
        return jianpanMapper.getJianpanCount(condition);
    }

    @Override
    public List<Goodsjianpan> getAll(Condition condition) {
        List<Goodsjianpan> goodsjianpans=jianpanMapper.getAll(condition);
        return goodsjianpans;
    }

    @Override
    public Goodsjianpan selectGooodsJianpanById(int id) {
        return jianpanMapper.selectGooodsJianpanById(id);
    }

    @Override
    public void updateKucun(int jnum, int id) {
                jianpanMapper.updateKucun(jnum,id);
    }

    @Override
    public void updatePrice(double jlastprice, double jorgprice, int id) {
                jianpanMapper.updatePrice(jlastprice,jorgprice,id);
    }

    @Override
    public void insertAddjian(Goodsjianpan goodsjianpan) {
                jianpanMapper.insertAddjian(goodsjianpan);
    }

    @Override
    public void deletegoodsjian(int id) {
        jianpanMapper.deletegoodsjian(id);

    }
}
