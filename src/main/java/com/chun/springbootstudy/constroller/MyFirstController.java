package com.chun.springbootstudy.constroller;

import com.chun.springbootstudy.config.GetMyApplicationPropertiesByValue;
import com.chun.springbootstudy.config.MyChunProperties;
import com.chun.springbootstudy.domain.MyPojo;
import com.chun.springbootstudy.service.MyFirstServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class MyFirstController {
    @Autowired
    private MyFirstServer myFirstServer;

    @Autowired
    private MyChunProperties properties;

    @Autowired
    private GetMyApplicationPropertiesByValue getMyApplicationPropertiesByValue;

    @GetMapping("/get")
    public String getInfo(){
        return myFirstServer.hello();
    }

    @GetMapping("/getProperties")
    public String getProperties(){
        var security = properties.getSecurity();
        return properties.getRemoteAddress() + "----" + properties.isEnabled() + "----" + security.getName() + "----" + security.getPassword();
    }

    @GetMapping("/getListForProp")
    public String getListForProp(){
        List<MyPojo> list = properties.getList();
        String result = "";
        for (MyPojo p : list){
            result = p.getName() + "---" + p.getDescription();
        }
        return result;
    }

    @GetMapping("/getMyApplicationPropertiesByValue")
    public String getMyApplicationPropertiesByValue(){
        return String.format("name: %s, age: %d, type: %s", getMyApplicationPropertiesByValue.getName(), getMyApplicationPropertiesByValue.getAge(), getMyApplicationPropertiesByValue.getType());
    }
}
