package com.chun.springbootstudy.service;

import com.chun.springbootstudy.domain.User;
import com.chun.springbootstudy.req.UserQuery;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface LuceneService {
    /**
     * 增加索引
     * @param list
     * @throws IOException
     */
    public void createUserIndex(List<User> list) throws IOException;

    public void updateUerIndex(User user) throws IOException;

    /**
     * 查询
     * @param pageQuery
     * @return
     * @throws Exception
     * @throws ParseException
     */
    public UserQuery searchUser(UserQuery pageQuery) throws Exception, ParseException;

    /**
     *删除
     * @param id
     * @throws IOException
     */
    public void deleteUserIndexById(String id) throws IOException;
}