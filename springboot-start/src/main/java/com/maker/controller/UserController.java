package com.maker.controller;

import com.maker.pojo.User;
import com.maker.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Auther: 【zhangjian】
 * @Date: 2019/6/13
 * @Description: com.maker.controller
 * @version: 1.0
 */
//@Controller
@RestController     //@RestController = @Controller + @ResponseBody
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    //@ResponseBody
    public User getUser() {
        User user =new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setAge(18);
        user.setBirthDate(new Date());
        user.setDescription("");
        return user;
    }

    @RequestMapping(value = "/getUserJson", method = RequestMethod.GET)
    //@ResponseBody
    public JsonResult getUserJson() {
        User user =new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setAge(18);
        user.setBirthDate(new Date());
        user.setDescription("描述");
        return JsonResult.ok(user);
    }
}
