package org.lanqiao.project.service;

import org.lanqiao.project.mapper.ManagerMapper;
import org.lanqiao.project.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService  implements ManagerMapper {
    @Autowired
    ManagerMapper managerMapper;
    @Override
    public Manager selectUsername(String username) {
        return managerMapper.selectUsername(username);
    }

    @Override
    public List<Manager> selectAll() {
        return managerMapper.selectAll();
    }

    @Override
    public void deleteUser(int id) {
        managerMapper.deleteUser(id);

    }
}
