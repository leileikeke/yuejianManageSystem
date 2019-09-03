package com.leike.service.impl;

import com.leike.mapper.ActivityMapper;
import com.leike.pojo.Activity;
import com.leike.service.ActivityService;
import com.leike.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-11 16:45
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> selectActivityListForTerm(Integer page, Integer limit, String name, String type, String cName) {
        List<Activity> activities = activityMapper.selectActivityListForTerm(page, limit, name, type, cName);
        return activities;
    }

    @Override
    public List<Activity> selectActivityList(Integer page, Integer limit) {
        List<Activity> activities = activityMapper.selectActivityList(page, limit);
        return activities;
    }

    @Override
    public Integer selectActivityCount() {
        int i = activityMapper.selectActivityCount();
        return i;
    }

    @Override
    public boolean updateActivity(Activity activity, String uploadPath) {
        //获取用户原头像
        String pic = activityMapper.selectActivityPic(activity.getaId());
        //如果修改了用户头像则删除原头像
        if (!activity.getPic().equals(pic)) {
            FileUtil.deleteFile(uploadPath, pic);
        }
        int i = activityMapper.updateActivity(activity);
        return i == 1 ? true : false;
    }

    @Override
    public boolean insertActivity(Activity activity) {
        int i = activityMapper.insertActivity(activity);
        return i == 1 ? true : false;
    }

    @Override
    public boolean deleteActivity(Integer aId, String pic, String uploadPath) {
        //删除服务器上的用户头像
        FileUtil.deleteFile(uploadPath, pic);
        int i = activityMapper.deleteActivity(aId);
        return i == 1 ? true : false;
    }

    @Override
    public List<Activity> selectActivityListForclubAdmin(Integer page, Integer limit, Integer id) {
        List<Activity> activities = activityMapper.selectActivityListForclubAdmin(page, limit, id);
        return activities;
    }

    @Override
    public Integer selectActivityCountForClubAdmin(Integer id) {
        Integer i = activityMapper.selectActivityCountForClubAdmin(id);
        return i;
    }

    //---------------客户端api-------------

    @Override
    public List<Activity> selectActivityForCId(Integer cId) {
        List<Activity> activities = activityMapper.selectActivityForCId(cId);
        return activities;
    }

    @Override
    public Activity selectActivityByAId(Integer aId) {
        Activity activity = activityMapper.selectActivityByAId(aId);
        return activity;
    }
}
