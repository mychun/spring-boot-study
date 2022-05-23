package com.chun.springbootstudy.controller;

import com.chun.springbootstudy.domain.Diana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autowired")
public class MoreTypeAutowiredConstroller {
    // 第一种私有属性注入
    // @Autowired
    private Diana diana;

    // 第二种构造函数注入
    // @Autowired
    public MoreTypeAutowiredConstroller(Diana diana){
        this.diana = diana;
    }

    //第三种 setter注入
    @Autowired
    public void setDiana(Diana diana) {
        this.diana = diana;
    }
}
