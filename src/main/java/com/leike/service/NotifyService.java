package com.leike.service;

import com.leike.pojo.Notify;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-09-05 16:31
 */
public interface NotifyService {


    Integer selectNotifyCount(Integer cId);

    List<Notify> selectNotifyList(Integer cId);

    Integer selectCIdById(Integer id);

    boolean deleteNotify(Integer jId);

}
