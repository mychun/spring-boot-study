package com.chun.springbootstudy.constroller;

import com.chun.springbootstudy.domain.User;
import javax.validation.constraints.Email;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/uservalidator")
public class UserValidatorController {
    @PostMapping("/testjson")
    public String testJson(@Validated @RequestBody User user){
        return "success";
    }

    @PostMapping("/testform")
    public String testform(@Validated User user){
        return "success";
    }

//    @PostMapping("/testparam")
//    public String testparam(@Email(message = "请填写正确的邮箱地址") String email){
//        return "success";
//    }
}
