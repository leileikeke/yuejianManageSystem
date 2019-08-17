package com.leike.pojo;

/**
 * 视频实体类
 *
 * @description:
 * @author: leike
 * @date: 2019-08-16 16:09
 */
public class Video {

    private Integer vId;

    private String name;

    private String video;

    private Integer cId;

    private String cName;

    public Video() {
    }

    public Video(Integer vId, String name, String video, Integer cId, String cName) {
        this.vId = vId;
        this.name = name;
        this.video = video;
        this.cId = cId;
        this.cName = cName;
    }

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Video{" +
                "vId=" + vId +
                ", name='" + name + '\'' +
                ", video='" + video + '\'' +
                ", cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
