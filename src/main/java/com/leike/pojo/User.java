package com.leike.pojo;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-05 21:12
 */
public class User {

    private Integer id;

    private String uName;

    private String password;

    private String pic;

    private String sex;

    private String phone;

    public User() {
    }

    public User(Integer id, String uName, String password, String pic, String sex, String phone) {
        this.id = id;
        this.uName = uName;
        this.password = password;
        this.pic = pic;
        this.sex = sex;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uName='" + uName + '\'' +
                ", password='" + password + '\'' +
                ", pic='" + pic + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
