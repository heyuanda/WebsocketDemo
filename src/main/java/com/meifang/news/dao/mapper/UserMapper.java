package com.meifang.news.dao.mapper;

import com.meifang.news.dao.domain.User;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    Integer setLastBreak(User user);
}
