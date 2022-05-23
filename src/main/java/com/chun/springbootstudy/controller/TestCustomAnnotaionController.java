package com.chun.springbootstudy.controller;

import com.chun.springbootstudy.annotations.MyAnnotaion;
import org.springframework.web.bind.annotation.RestController;

@MyAnnotaion
@RestController
public class TestCustomAnnotaionController {

    @MyAnnotaion
    public void a(){}
}
