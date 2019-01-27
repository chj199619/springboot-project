package org.lanqiao.project.service;

import org.lanqiao.project.mapper.YLRateMapper;
import org.lanqiao.project.pojo.YLRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateService  implements YLRateMapper {
    @Autowired
    YLRateMapper ylRateMapper;
    @Override
    public void insertRate(YLRate ylRate) {
        ylRateMapper.insertRate(ylRate);
    }
}
