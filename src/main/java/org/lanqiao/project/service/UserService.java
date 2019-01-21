package org.lanqiao.project.service;

import org.lanqiao.project.mapper.UserMapper;
import org.lanqiao.project.pojo.Condition;
import org.lanqiao.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserMapper {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        List<User> userList=userMapper.selectAll();
        return userList;
    }

    @Override
    public User selectUserById(int u_id) {
       return userMapper.selectUserById(u_id);

    }

    @Override
    public void insertUser(User user) {
       userMapper.insertUser(user);
    }

    @Override
    public void updateUser( String u_password,int u_id) {
        userMapper.updateUser(u_password,u_id);
    }

//    @Override
//    public void updateUser(User user) {
//        userMapper.updateUser(user);
//    }


    @Override
    public void deleteUser(int u_id) {
        userMapper.deleteUser(u_id);
    }

    @Override
    public int getUserCount(Condition condition) {
        return userMapper.getUserCount(condition);
    }

    @Override
    public List<User> getAll(Condition condition) {
        List<User> userList = userMapper.getAll(condition);
        return userList;
    }


}
