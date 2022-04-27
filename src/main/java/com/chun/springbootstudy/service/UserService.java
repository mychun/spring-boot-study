package com.chun.springbootstudy.service;

import com.chun.springbootstudy.domain.User;

import java.util.List;

public interface UserService {
    User getUserInfo(int id);
    int deleteById(int id);
    int Update(User user);
    User save(User user);
    List<User> selectAll();
}
