package com.maker.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration//引用配置文件配置
@ConfigurationProperties(prefix="com.maker")//配置文件属性前缀
@PropertySource(value="classpath:resource.properties",encoding = "GBK")//配置文件路径：发包后编译文件会在classpath下
public class Resource {
	private String name;
	private String website;
	private String language;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
