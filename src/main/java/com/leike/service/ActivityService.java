package com.leike.service;

import com.leike.pojo.Activity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-11 16:45
 */
public interface ActivityService {

    List<Activity> selectActivityListForTerm(Integer page, Integer limit, String name, String type, String cName);

    List<Activity> selectActivityList(Integer page, Integer limit);

    Integer selectActivityCount();

    boolean updateActivity(Activity activity, String uploadPath);

    boolean insertActivity(Activity activity);

    boolean deleteActivity(Integer aId, String pic, String uploadPath);

    List<Activity> selectActivityListForclubAdmin(Integer page, Integer limit, Integer id);

    Integer selectActivityCountForClubAdmin(Integer id);

    Activity selectActivityForCId(Integer cId);

}
