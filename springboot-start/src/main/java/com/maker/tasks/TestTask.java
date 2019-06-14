package com.maker.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component//作为组件可以被spring容器扫描
public class TestTask {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	// 定义每过3秒执行任务
//    @Scheduled(fixedRate = 3000)
//	@Scheduled(cron = "4-40 * * * * ?")//http://cron.qqe2.com   spring boot cron表达式只支持6位
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
