package com.liaobei.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author whr
 * @description 用户
 */

public class User {
    private int id;
    private String username;
    private String sex;
    private String telNumber;
    @JsonIgnore
    private String password;//生成json时不序列化此属性
    private int state;
    private int height;
    private String address;
    private String avatar;
    private Date birth;
    private String desc;
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", height=" + height +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", birth=" + birth +
                ", desc='" + desc + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
