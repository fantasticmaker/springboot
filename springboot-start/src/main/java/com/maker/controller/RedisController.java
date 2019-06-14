package com.maker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.maker.pojo.User;
import com.maker.utils.JsonResult;
import com.maker.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maker.pojo.SysUser;
import com.maker.utils.RedisOperator;

@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;
	
	@Autowired
	private RedisOperator redis;//redis命令工具类
	
	@RequestMapping("/test")
	public JsonResult test() {
		
		strRedis.opsForValue().set("imaker-cache", "hello 慕课网~~~~~~");
		
		SysUser user = new SysUser();
		user.setId("100111");
		user.setUsername("张三");
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));
		
		SysUser jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), SysUser.class);
		
		return JsonResult.ok(jsonUser);
	}
	
	@RequestMapping("/getJsonList")
	public JsonResult getJsonList() {

		User user = new User();
		user.setAge(18);
		user.setUsername("张三");
		user.setPassword("123456");
		user.setBirthDate(new Date());

		User u1 = new User();
		u1.setAge(19);
		u1.setUsername("李四");
		u1.setPassword("123456");
		u1.setBirthDate(new Date());

		User u2 = new User();
		u2.setAge(17);
		u2.setUsername("王五");
		u2.setPassword("123456");
		u2.setBirthDate(new Date());
		
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);//redis数据存储
		
		String userListJson = redis.get("json:info:userlist");//reids数据取出
		List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);//转换成list
		
		return JsonResult.ok(userListBorn);//存入json返回值
	}
}