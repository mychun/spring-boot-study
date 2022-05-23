package com.chun.springbootstudy.controller;

import com.chun.springbootstudy.domain.Diana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lazy")
@Lazy
public class LazyTestConstroller {
    @Autowired
    private Diana diana;

    @GetMapping("/hero")
    public String hero(){
        diana.r();
        return "success";
    }
}
