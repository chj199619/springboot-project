package org.lanqiao.project.service;

import org.lanqiao.project.mapper.RateadminMapper;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RateadminService implements RateadminMapper {
    @Autowired
    RateadminMapper rateadminMapper;
    @Override
    public int getRateCount(Condition condition) {
        return rateadminMapper.getRateCount(condition);
    }

    @Override
    public List<Rate> getAll(Condition condition) {
        List<Rate>rateList=rateadminMapper.getAll(condition);
        return rateList;
    }

    @Override
    public void deleteRate(int rate_id) {
        rateadminMapper.deleteRate(rate_id);
    }

    @Override
    public Rate selectRateByid(int rate_id) {
        return rateadminMapper.selectRateByid(rate_id);
    }

    @Override
    public void updateRate(String answernews, int rate_id) {
        rateadminMapper.updateRate(answernews,rate_id);
    }
}
