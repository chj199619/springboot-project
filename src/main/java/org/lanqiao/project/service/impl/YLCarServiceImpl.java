package org.lanqiao.project.service.impl;

import org.lanqiao.project.mapper.YLMapper;
import org.lanqiao.project.pojo.YLCar;
import org.lanqiao.project.pojo.YLPaper;
import org.lanqiao.project.pojo.YLPerson;
import org.lanqiao.project.service.YLCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YLCarServiceImpl implements YLCarService {
    @Autowired
    YLMapper mapper;
    @Override
    public List<YLCar> getAll(int u_id, int p_id) {
        return mapper.ylgetAll(u_id,p_id);
    }

    @Override
    public List<YLPaper> lgetAll(String cond) {
        return mapper.lgetAll(cond);
    }

    @Override
    public List<YLCar> getAllCar() {
        return mapper.getAllCar();
    }

    @Override
    public List<YLCar> getListByid(int g_id) {
        return mapper.getListByid(g_id);
    }

    @Override
    public void insertPaper(YLPaper paper) {
        mapper.addPaper(paper);
    }

    @Override
    public YLPerson getUserById(int id) {
        return mapper.getUserById(id);
    }

    @Override
    public void findUpdate(YLPerson ylPerson) {
        mapper.getUpdate(ylPerson);
    }

    @Override
    public void longlongUpdate(int p_id, int u_id) {
        mapper.yulongUpdate(p_id, u_id);
    }

    @Override
    public void YLUpdateCar(YLCar car) {
        mapper.ylUpdateCar(car);
    }

    @Override
    public List<YLCar> carWei(int u_id, String cond) {
        return mapper.carWei(u_id,cond);
    }

    @Override
    public List<YLCar> sAll(int u_id) {
        return mapper.sAll(u_id);
    }

    @Override
    public YLCar yselect(int g_id) {
        return mapper.yselect(g_id);
    }

    @Override
    public void yUpdate(YLCar car) {
        mapper.yUpdate(car);
    }
}
