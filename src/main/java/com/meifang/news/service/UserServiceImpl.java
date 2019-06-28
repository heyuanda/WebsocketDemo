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
        return  userMapper.select(user).get(0);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectAll();
    }
}
