package com.meifang.news.service;

import com.meifang.news.dao.domain.User;
import com.meifang.news.dao.mapper.UserMapper;
import com.meifang.news.service.Exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserMapper userMapper;
    @Override
    public Integer reg(User user) throws InsertException {
        System.out.println(user);
        Integer row=userMapper.insert(user);
        if(row!=1)throw new InsertException();
        return row;
    }

    @Override
    public User login(User user) {
        List<User> users=userMapper.select(user);
        return  users.size()>0?users.get(0):null;
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectAll();
    }

    @Override
    public Integer setLastBreak(User user) {
        return userMapper.setLastBreak(user);
    }
}
