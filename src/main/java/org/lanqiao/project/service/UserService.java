package org.lanqiao.project.service;

import org.lanqiao.project.mapper.UserMapper;
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
}
