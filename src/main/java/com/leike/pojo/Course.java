package com.leike.pojo;

/**
 * 课程实体类
 *
 * @description:
 * @author: leike
 * @date: 2019-08-14 14:42
 */
public class Course {

    private Integer kId;

    private String name;

    private String intro;

    private Integer classHours;

    private Double price;

    private String pic;

    private Integer jId;

    private String jName;

    public Course() {
    }

    public Course(Integer kId, String name, String intro, Integer classHours, Double price, String pic, Integer jId, String jName) {
        this.kId = kId;
        this.name = name;
        this.intro = intro;
        this.classHours = classHours;
        this.price = price;
        this.pic = pic;
        this.jId = jId;
        this.jName = jName;
    }

    public Integer getkId() {
        return kId;
    }

    public void setkId(Integer kId) {
        this.kId = kId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getClassHours() {
        return classHours;
    }

    public void setClassHours(Integer classHours) {
        this.classHours = classHours;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "kId=" + kId +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", classHours=" + classHours +
                ", price='" + price + '\'' +
                ", pic='" + pic + '\'' +
                ", jId=" + jId +
                ", jName='" + jName + '\'' +
                '}';
    }
}
