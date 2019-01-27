package org.lanqiao.project.service;

import org.lanqiao.project.pojo.YLCar;
import org.lanqiao.project.pojo.YLPaper;
import org.lanqiao.project.pojo.YLPerson;

import java.util.List;

public interface YLCarService {
    public List<YLCar> getAll(int u_id, int p_id);
    public List<YLPaper> lgetAll(String cond);
    public List<YLCar> getAllCar();
    public List<YLCar> getListByid(int g_id);
    public void insertPaper(YLPaper paper);
    public YLPerson getUserById(int id);
    public void findUpdate(YLPerson ylPerson);
    public void longlongUpdate(int p_id, int u_id);
    public void YLUpdateCar(YLCar car);
    public List<YLCar> carWei(int u_id, String cond);
    public List<YLCar> sAll(int u_id);
    public YLCar yselect(int g_id);
    public void yUpdate(YLCar car);

}
