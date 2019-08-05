package com.leike.pojo;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-03 16:44
 */
public class Admin {

    private Integer id;

    private String name;

    private String nickname;

    private String password;

    private String phone;

    private String sex;

    private String role;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String jointime;

    private Boolean state;



    public Admin() {
    }

    public Admin(Integer id, String name, String nickname, String password, String phone, String sex, String role, String jointime, Boolean state) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.role = role;
        this.jointime = jointime;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", role='" + role + '\'' +
                ", jointime='" + jointime + '\'' +
                ", state=" + state +
                '}';
    }
}
