package com.liaobei.pojo;

import java.util.Date;

/**
 * @author whr
 * @description 发表朋友圈类，对照数据库中的wechat表
 */
public class Wechat {
    private int id;
    private String username;
    private String avatar;
    private String content;
    private Date date;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Wechat{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                '}';
    }
}
