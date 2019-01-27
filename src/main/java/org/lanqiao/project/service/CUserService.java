package org.lanqiao.project.service;

import org.lanqiao.project.mapper.CUserMapper;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.CUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CUserService implements CUserMapper {

    @Autowired
    CUserMapper cUserMapper;

    @Override
    public List<CUser> selectAll() {
        List<CUser> userList=cUserMapper.selectAll();
        return userList;
    }

    @Override
    public CUser selectUserById(int u_id) {
       return cUserMapper.selectUserById(u_id);

    }

    @Override
    public void insertUser(CUser user) {
        cUserMapper.insertUser(user);
    }

    @Override
    public void updateUser( String u_password,int u_id) {
        cUserMapper.updateUser(u_password,u_id);
    }

//    @Override
//    public void updateUser(User user) {
//        userMapper.updateUser(user);
//    }


    @Override
    public void deleteUser(int u_id) {
        cUserMapper.deleteUser(u_id);
    }

    @Override
    public int getUserCount(Condition condition) {
        return cUserMapper.getUserCount(condition);
    }

    @Override
    public List<CUser> getAll(Condition condition) {
        List<CUser> userList = cUserMapper.getAll(condition);
        return userList;
    }


}
