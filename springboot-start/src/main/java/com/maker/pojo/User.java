package com.maker.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.Date;

/**
 * @Auther: 【zhangjian】
 * @Date: 2019/6/13
 * @Description: com.maker.pojo
 * @version: 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)//如果为空不返回
public class User {

    private String username;

    @JsonIgnore     //忽略属性
    private String password;

    private Integer age;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss a", locale="zh", timezone="GMT+8")//日期格式
    private Date birthDate;

    private String description;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", description='" + description + '\'' +
                '}';
    }
}
