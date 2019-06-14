package com.maker.tasks;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
public class DoTask {
	/**
	 * 异步任务使用场景
	 * 1.发送短信
	 * 2.发送邮件
	 * 3.APP消息推送
	 * 4.节省任务发布时间提高效率
	 * 
	 * */
	@Autowired
    private AsyncTask asyncTask;
	
    @RequestMapping("test1")
    public String test1() throws Exception {
    	
    	long start = System.currentTimeMillis();
    	
    	Future<Boolean> a = asyncTask.doTask11();
    	Future<Boolean> b = asyncTask.doTask22();
    	Future<Boolean> c = asyncTask.doTask33();
    	
    	while (!a.isDone() || !b.isDone() || !c.isDone()) {//只要有任务没有完成就必须执行死循环，直到所有任务都完成，打印时间
    		if (a.isDone() && b.isDone() && c.isDone()) {
    			break;
    		}
    	}
    	
    	long end = System.currentTimeMillis();
    	
    	String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
    	System.out.println(times);
    	
    	return times;
    }
}
