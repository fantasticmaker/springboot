package com.maker.controller.interceptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.maker.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("two")
public class TwoController {

	@RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "itzixi22");
        return "thymeleaf/index";
    }
	
	@RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

	@RequestMapping("test")
    public String test(ModelMap map) {
		
		User user = new User();
		user.setAge(18);
		user.setUsername("manager");
		user.setPassword("123456");
		user.setBirthDate(new Date());
		
		map.addAttribute("user", user);


		User u1 = new User();
		u1.setAge(19);
		u1.setUsername("itzixi");
		u1.setPassword("123456");
		u1.setBirthDate(new Date());

		User u2 = new User();
		u2.setAge(17);
		u2.setUsername("LeeCX");
		u2.setPassword("123456");
		u2.setBirthDate(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		map.addAttribute("userList", userList);
		
        return "thymeleaf/test";
    }
	
	@PostMapping("postform")
    public String postform(User user) {
		System.out.println(user.getUsername());
        return "redirect:/th/test";
    }
}