package com.meifang.news.service;

import com.meifang.news.dao.domain.User;

import java.util.List;

public interface UserService {
    Integer reg(User user);
    User login(User user);
    List<User> getUsers();
    Integer setLastBreak(User user);
}
