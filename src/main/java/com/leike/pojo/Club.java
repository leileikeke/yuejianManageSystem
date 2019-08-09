package com.leike.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-09 21:48
 */
public class Club {

    private Integer cId;

    private String name;

    private String phone;

    private String pic;

    private String intro;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date jointime;

    private Integer hot;

    public Club() {
    }

    public Club(Integer cId, String name, String phone, String pic, String intro, String address, Date jointime, Integer hot) {
        this.cId = cId;
        this.name = name;
        this.phone = phone;
        this.pic = pic;
        this.intro = intro;
        this.address = address;
        this.jointime = jointime;
        this.hot = hot;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "Club{" +
                "cId=" + cId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", pic='" + pic + '\'' +
                ", intro='" + intro + '\'' +
                ", address='" + address + '\'' +
                ", jointime=" + jointime +
                ", hot=" + hot +
                '}';
    }
}
