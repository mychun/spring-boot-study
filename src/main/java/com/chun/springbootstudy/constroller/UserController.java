package com.chun.springbootstudy.constroller;


import com.chun.springbootstudy.domain.User;
import com.chun.springbootstudy.resp.R;
import com.chun.springbootstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //通过用户id获取用户所有信息
    //    http://localhost:8080/testBoot/getUser/1(此处1为要获取的id）
    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    //    http://localhost:8080/testBoot/getUser?id=1(此处1为要获取的id）
    //    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public R GetUser(@PathVariable int id) {
        final User userInfo = userService.getUserInfo(id);
        return R.ok().data("user", userInfo);
    }

    //通过用户id删除用户
    //    http://localhost:8080/testBoot/delete?id=1(此处1为要删除的id）
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public R delete(@PathVariable int id) {
        int result = userService.deleteById(id);
        if (result >= 1) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    //根据用户id更新用户信息
    //http://localhost:8080/testBoot/update?id=2&userName=波波&passWord=123456&realName=lalala
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody User user) {
        int result = userService.Update(user);
        if (result >= 1) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    //插入新用户
    //    http://localhost:8080/testBoot/insert?id=100&userName=波波&passWord=123456&realName=lalala
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody User user) {
        final User u = userService.save(user);
        if(u != null){
            return R.ok();
        } else{
            return R.error();
        }
    }
    //打印所有用户信息
    //    http://localhost:8080/testBoot/selectAll
    @RequestMapping("/selectAll")
    @ResponseBody
    public R ListUser() {
        final List<User> users = userService.selectAll();
        return R.ok().data("itms", users);
    }
}
