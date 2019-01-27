package org.lanqiao.project.service;

import org.lanqiao.project.mapper.UserMapper;
import org.lanqiao.project.pojo.CUser;
import org.lanqiao.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService implements UserMapper {
    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> selectAll1() {
        return userMapper.selectAll1();
    }

    @Override
    public User selectUser1(String u_name) throws SQLException {
        return userMapper.selectUser1(u_name);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);

    }
}
