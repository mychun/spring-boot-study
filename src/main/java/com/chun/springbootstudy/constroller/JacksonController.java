package com.chun.springbootstudy.constroller;

import com.chun.springbootstudy.domain.MyPojo;
import com.chun.springbootstudy.resp.JsonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jackson")
public class JacksonController {
    @GetMapping("/get")
    public JsonResponse<Map> testJson(){
        Map<Integer, MyPojo> myPojoMap = new HashMap<>();
        final MyPojo myPojo = new MyPojo();
        myPojo.setName("Mike");
//        myPojo.setDescription("哈哈");
        myPojoMap.put(1, myPojo);
        return new JsonResponse<Map>(myPojoMap);
    }
}
