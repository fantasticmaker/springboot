package com.maker.controller;

import com.maker.pojo.Resource;
import com.maker.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 【zhangjian】
 * @Date: 2019/6/13
 * @Description: com.maker.controller
 * @version: 1.0
 */
@RestController
public class HelloController {
    @Autowired
    private Resource resource;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello Spring Boot";
    }


    @RequestMapping("/getResource")
    public JsonResult getResult() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);//拷贝属性到实例化实体中
        return JsonResult.ok(bean);
    }
}
