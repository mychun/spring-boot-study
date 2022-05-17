package com.chun.springbootstudy.constroller;

import com.chun.springbootstudy.service.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condition")
public class ConditionTestConstroller {

    @Autowired
    private Fruit fruit;

    @GetMapping
    public String test(){
        return "success";
    }
}
