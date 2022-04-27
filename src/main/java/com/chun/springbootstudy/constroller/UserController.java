package com.chun.springbootstudy.constroller;


import com.chun.springbootstudy.domain.User;
import com.chun.springbootstudy.resp.JsonResponse;
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
    public JsonResponse<User> GetUser(@PathVariable int id) {
        final User userInfo = userService.getUserInfo(id);
        return new JsonResponse<User>(userInfo);
    }

    //通过用户id删除用户
    //    http://localhost:8080/testBoot/delete?id=1(此处1为要删除的id）
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable int id) {
        int result = userService.deleteById(id);
        if (result >= 1) {
            return new JsonResponse();
        } else {
            return new JsonResponse(500, "删除失败");
        }
    }
    //根据用户id更新用户信息
    //http://localhost:8080/testBoot/update?id=2&userName=波波&passWord=123456&realName=lalala
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonResponse update(@RequestBody User user) {
        int result = userService.Update(user);
        if (result >= 1) {
            return new JsonResponse();
        } else {
            return new JsonResponse(500, "修改失败");
        }
    }
    //插入新用户
    //    http://localhost:8080/testBoot/insert?id=100&userName=波波&passWord=123456&realName=lalala
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public JsonResponse insert(@RequestBody User user) {
        final User u = userService.save(user);
        if(u != null){
            return new JsonResponse();
        } else{
            return new JsonResponse(500,"添加失败");
        }
    }
    //打印所有用户信息
    //    http://localhost:8080/testBoot/selectAll
    @RequestMapping("/selectAll")
    @ResponseBody
    public JsonResponse<List<User>> ListUser() {
        final List<User> users = userService.selectAll();

        return new JsonResponse<List<User>>(users);
    }
}
