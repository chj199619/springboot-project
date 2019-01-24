package org.lanqiao.project.service;

import org.lanqiao.project.mapper.TypeMapper;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements TypeMapper{
    @Autowired
    TypeMapper typeMapper;

    @Override
    public int getTypeCount(Condition condition) {
        return typeMapper.getTypeCount(condition);
    }

    @Override
    public List<Type> getAll(Condition condition) {
        List<Type> typeList=typeMapper.getAll(condition);
        return typeList;
    }

    @Override
    public void deleteType(int id) {
        typeMapper.deleteType(id);

    }

    @Override
    public Type selectTypeByid(int id) {
        return  typeMapper.selectTypeByid(id);
    }

    @Override
    public void updateRate(String zhuangtai, String x_time, int id) {
        typeMapper.updateRate(zhuangtai,x_time,id);
    }

    @Override
    public void updateRate2(String zhuangtai, String s_time, int id) {
        typeMapper.updateRate(zhuangtai,s_time,id);

    }

    @Override
    public void updateRate3(String zhuangtai, String s_time, String x_time, int id) {
        typeMapper.updateRate3(zhuangtai,s_time,x_time,id);

    }




    @Override
    public void insertType(Type type) {
        typeMapper.insertType(type);

    }

    @Override
    public int getGoodscomputnum() {
        return typeMapper.getGoodscomputnum();
    }

    @Override
    public int getGoodscomputernum() {
        return typeMapper.getGoodscomputernum();
    }

    @Override
    public int getGoodscomputernum1() {
        return typeMapper.getGoodscomputernum1();
    }
}
