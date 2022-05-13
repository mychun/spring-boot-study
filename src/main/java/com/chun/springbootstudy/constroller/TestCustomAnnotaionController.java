package com.chun.springbootstudy.constroller;

import com.chun.springbootstudy.annotations.MyAnnotaion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@MyAnnotaion
@RestController
public class TestCustomAnnotaionController {

    @MyAnnotaion
    public void a(){}
}
