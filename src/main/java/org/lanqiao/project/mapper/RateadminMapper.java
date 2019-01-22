package org.lanqiao.project.mapper;

import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Rate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RateadminMapper {
    //分页
    public int getRateCount(Condition condition);
    public List<Rate> getAll(Condition condition);
    //shanchu
    public void deleteRate(int rate_id);

}
