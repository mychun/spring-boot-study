package com.chun.springbootstudy.controller;

import com.chun.springbootstudy.annotations.MyLog;
import com.chun.springbootstudy.domain.MyPojo;
import com.chun.springbootstudy.resp.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jackson")
public class JacksonController {

    @MyLog
    @GetMapping("/get")
    public R testJson(){
        Map<Integer, MyPojo> myPojoMap = new HashMap<>();
        final MyPojo myPojo = new MyPojo();
        myPojo.setName("Mike");
//        myPojo.setDescription("哈哈");
        myPojoMap.put(1, myPojo);
        return R.ok().data("itm", myPojoMap);
    }
}
