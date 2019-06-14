package com.maker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描 mybatis mapper 包路径：进行映射
@MapperScan(basePackages = "com.maker.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径:扫描之后才可以进行依赖注入
@ComponentScan(basePackages= {"com.maker"})
//开启定时任务:会自动扫描
@EnableScheduling
//开启异步调用方法:与@Async标签配合使用
@EnableAsync
public class SpringbootStartApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootStartApplication.class, args);
	}


}
