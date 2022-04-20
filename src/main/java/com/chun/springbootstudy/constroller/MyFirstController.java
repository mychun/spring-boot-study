package com.chun.springbootstudy.constroller;

import com.chun.springbootstudy.config.MyChunProperties;
import com.chun.springbootstudy.service.MyFirstServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MyFirstController {
    @Autowired
    private MyFirstServer myFirstServer;

    @Autowired
    private MyChunProperties properties;

    @GetMapping("/get")
    public String getInfo(){
        return myFirstServer.hello();
    }

    @GetMapping("/getProperties")
    public String getProperties(){
        var security = properties.getSecurity();
        return properties.getRemoteAddress() + "----" + properties.isEnabled() + "----" + security.getName() + "----" + security.getPassword();
    }
}
