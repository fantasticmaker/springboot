package com.maker.mapper;

import java.util.List;

import com.maker.pojo.SysUser;

public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}