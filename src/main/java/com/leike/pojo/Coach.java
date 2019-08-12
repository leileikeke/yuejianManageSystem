package com.leike.pojo;

/**
 * 教练/大师实体类
 *
 * @description:
 * @author: leike
 * @date: 2019-08-13 2:25
 */
public class Coach {

    private Integer jId;

    private String name;

    private String pic;

    private String sex;

    private String phone;

    private String email;

    private String intro;

    private Boolean state;

    private Integer cId;

    public Coach() {
    }

    public Coach(Integer jId, String name, String pic, String sex, String phone, String email, String intro, Boolean state, Integer cId) {
        this.jId = jId;
        this.name = name;
        this.pic = pic;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.intro = intro;
        this.state = state;
        this.cId = cId;
    }

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "jId=" + jId +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", intro='" + intro + '\'' +
                ", state=" + state +
                ", cId=" + cId +
                '}';
    }
}
