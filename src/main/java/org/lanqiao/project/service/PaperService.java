package org.lanqiao.project.service;

import org.lanqiao.project.mapper.PaperMapper;
import org.lanqiao.project.pojo.Cond;
import org.lanqiao.project.pojo.Paper;
import org.lanqiao.project.pojo.psCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService implements PaperMapper {
    @Autowired
    PaperMapper paperMapper;
    @Override
    public List<Paper> findAll() {
        List<Paper> papers= paperMapper.findAll();
        return papers;
    }

    @Override
    public void deletePaper(Integer id) {
        paperMapper.deletePaper(id);
    }

    @Override
    public Paper findById(Integer id) {
        return  paperMapper.findById(id);
    }

    @Override
    public Paper findByOne(Integer ddid) {
        return paperMapper.findByOne(ddid);
    }

    @Override
    public List<Paper> findByDdid(Integer ddid) {
        return paperMapper.findByDdid(ddid);
    }

    @Override
    public List<Paper> fingBycondition(String condition) {
        return paperMapper.fingBycondition(condition);
    }

    @Override
    public void update(Paper paper) {
        paperMapper.update(paper);
    }

    @Override
    public List<Cond> conds() {
        return paperMapper.conds();
    }

    @Override
    public List<psCar> details(int pid, int uid) {
        return paperMapper.details(pid,uid);
    }

}