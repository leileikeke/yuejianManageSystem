package com.leike.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 活动实体类
 *
 * @description:
 * @author: leike
 * @date: 2019-08-11 16:33
 */
public class Activity {

    private Integer aId;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    private String address;

    private String pic;

    private Double price;

    private String type;

    private String detail;

    private Integer cId;

    private String cName;

    public Activity() {
    }

    public Activity(Integer aId, String name, Date startTime, Date endTime, String address, String pic, Double price, String type, String detail, Integer cId, String cName) {
        this.aId = aId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
        this.pic = pic;
        this.price = price;
        this.type = type;
        this.detail = detail;
        this.cId = cId;
        this.cName = cName;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "aId=" + aId +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", address='" + address + '\'' +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", detail='" + detail + '\'' +
                ", cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
