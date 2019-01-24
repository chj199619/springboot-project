package org.lanqiao.project.service;

import org.lanqiao.project.mapper.PsPaperMapper;

import org.lanqiao.project.pojo.PsPaper;
import org.lanqiao.project.pojo.User;
import org.lanqiao.project.pojo.psCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsPaperService implements PsPaperMapper {
    @Autowired
    PsPaperMapper paperMapper;
    @Override
    public List<PsPaper> findAll() {
        List<PsPaper> papers= paperMapper.findAll();
        return papers;
    }

    @Override
    public void deletePaper(Integer id) {
        paperMapper.deletePaper(id);
    }

    @Override
    public PsPaper findById(Integer id) {
        return  paperMapper.findById(id);
    }

    @Override
    public PsPaper findByOne(Integer ddid) {
        return paperMapper.findByOne(ddid);
    }

    @Override
    public List<PsPaper> findByDdid(Integer ddid) {
        return paperMapper.findByDdid(ddid);
    }

    @Override
    public List<PsPaper> fingBycondition(String condition) {
        return paperMapper.fingBycondition(condition);
    }

    @Override
    public void update(PsPaper paper) {
        paperMapper.update(paper);
    }



    @Override
    public List<psCar> details(int pid, int uid) {
        return paperMapper.details(pid,uid);
    }

    @Override
    public User user(int u_id) {
        return paperMapper.user(u_id);
    }
}