package com.maker.controller;

import com.maker.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 【zhangjian】
 * @Date: 2019/6/13
 * @Description: com.maker.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("name","张三");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap map) {
        User u = new User();
        u.setUsername("superadmin");
        u.setAge(10);
        u.setPassword("123465");
        u.setBirthDate(new Date());
        u.setDescription("<font color='green'><b>hello springboot~~</b></font>");

        map.addAttribute("user", u);

        User u1 = new User();
        u1.setAge(19);
        u1.setUsername("springboot");
        u1.setPassword("123456");
        u1.setBirthDate(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setUsername("张三");
        u2.setPassword("123456");
        u2.setBirthDate(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);

        map.addAttribute("userList", userList);

        return "thymeleaf/test";
    }

    @PostMapping("postform")
    public String postform(User u) {

        System.out.println("姓名：" + u.getUsername());
        System.out.println("年龄：" + u.getAge());

        return "redirect:/th/test";
    }

    @RequestMapping("showerror")
    public String showerror(User u) {

        int a = 1 / 0;

        return "redirect:/th/test";
    }
}
