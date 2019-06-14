package com.maker.controller;

import java.util.Date;
import java.util.List;

import com.maker.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maker.pojo.SysUser;
import com.maker.service.UserService;
import com.maker.utils.Common;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/saveUser")
	public JsonResult saveUser() throws Exception {
		
		String userId = Common.getUUID();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("maker" + new Date());
		user.setNickname("maker" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return JsonResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public JsonResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("11754cc431c442be875f0abd1ef2877d");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return JsonResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public JsonResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return JsonResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public JsonResult queryUserById(String userId) {
		
		return JsonResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public JsonResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("maker");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return JsonResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public JsonResult queryUserListPaged(Integer page) {//默认判断page的页面，如果不符合返回第一页或最后一页
		
		if (page == null) {
			page = 1;//第几页
		}

		int pageSize = 10;//每页显示多少条
		
		SysUser user = new SysUser();
//		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return JsonResult.ok(userList);
	}
	
	/**
	 * 自定义mapper进行sql语句查询
	 * @param userId
	 * @return
	 */
	@RequestMapping("/queryUserByIdCustom")
	public JsonResult queryUserByIdCustom(String userId) {
		
		return JsonResult.ok(userService.queryUserByIdCustom(userId));
	}

	@RequestMapping("/saveUserTransactional")
	public JsonResult saveUserTransactional() {
		
		String userId = Common.getUUID();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return JsonResult.ok("保存成功");
	}
}
