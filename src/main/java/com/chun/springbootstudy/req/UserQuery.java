package com.chun.springbootstudy.req;

import com.chun.springbootstudy.domain.Sort;
import com.chun.springbootstudy.domain.User;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UserQuery {
    /**
     * 排序字段
     */
    private Sort sort;
    /**
     * 查询参数类
     */
    private User params;
    /**
     * 返回结果集
     */
    private List<User> results;
    /**
     * 不在T类中的参数
     */
    private Map<String, String> queryParam;
}
