package com.chun.springbootstudy.controller;


import com.chun.springbootstudy.domain.User;
import com.chun.springbootstudy.req.UserQuery;
import com.chun.springbootstudy.resp.R;
import com.chun.springbootstudy.service.LuceneService;
import com.chun.springbootstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LuceneService luceneService;

    //通过用户id获取用户所有信息
    //    http://localhost:8080/testBoot/getUser/1(此处1为要获取的id）
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    //    http://localhost:8080/testBoot/getUser?id=1(此处1为要获取的id）
    //    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public R GetUser(@PathVariable int id) {
        final User userInfo = userService.getUserInfo(id);

//        if (userInfo == null) {
//            throw new IllegalArgumentException("用户不存在");
//        }
        //Assert 解决 参数和业务数据之间校验
        Assert.notNull(userInfo, "用户不存在");
//        Assert.isInstanceOf(UserService.class, userInfo, "不是该对象的继承者");
//        Assert.isAssignable(UserService.class, User.class, "不是可转换的类型");

//        String str = null;
//        Assert.hasLength(str, "至少包含一个字符");

//        String str = "";
//        String str = " ";
//        String str = "a ";
//        Assert.hasText(str, "至少包含一个非空白字符");

//        String str = "我是中国人";
//        Assert.doesNotContain(str, "中国人", "不能包含该字符串");

//        Assert.isTrue(false, "条件为假抛出异常");

//        String[] strArr= {"1", null, "2"};
//        Assert.noNullElements(strArr, "不能包含null成员");

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
    public R update(@RequestBody User user) throws IOException {
        int result = userService.Update(user);
        if (result >= 1) {
            //更新lucene索引
            luceneService.updateUerIndex(userService.getUserInfo(user.getId()));
            return R.ok();
        } else {
            return R.error();
        }
    }
    //插入新用户
    //    http://localhost:8080/testBoot/insert?id=100&userName=波波&passWord=123456&realName=lalala
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public R insert(@RequestBody User user) throws IOException {
        final User u = userService.save(user);
        if(u != null){
            List<User> list = new ArrayList<>(){};
            list.add(user);
            //创建lucene索引
            luceneService.createUserIndex(list);
            return R.ok();
        } else {
            return R.error();
        }
    }
    //打印所有用户信息
    //    http://localhost:8080/testBoot/selectAll
    @RequestMapping("/selectAll")
    @ResponseBody
    public R ListUser() throws IOException {
        final List<User> users = userService.selectAll();
        luceneService.createUserIndex(users);
        return R.ok().data("itms", users);
    }

    @RequestMapping(value = "/findUserBylucene", method = RequestMethod.POST)
    public R findUserBylucene(@RequestBody User user) throws Exception {
        UserQuery userQuery = new UserQuery();
        userQuery.setParams(user);
        UserQuery result  = luceneService.searchUser(userQuery);
        return R.ok().data("itms", result.getResults());
    }
}
