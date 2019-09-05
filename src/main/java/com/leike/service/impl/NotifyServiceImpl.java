package com.leike.service.impl;

import com.leike.mapper.NotifyMapper;
import com.leike.pojo.Notify;
import com.leike.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-09-05 16:31
 */
@Service("notifyService")
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private NotifyMapper notifyMapper;

    @Override
    public Integer selectNotifyCount(Integer cId) {
        int count = notifyMapper.selectNotifyCount(cId);
        return count;
    }

    @Override
    public List<Notify> selectNotifyList(Integer cId) {
        List<Notify> notifies = notifyMapper.selectNotifyList(cId);
        for (Notify notify : notifies) {
            String name = notifyMapper.queryAdminNameById(notify.getId());
            notify.setaName(name);
        }
        return notifies;
    }

    @Override
    public Integer selectCIdById(Integer id) {
        int cId = notifyMapper.selectCIdById(id);
        return cId;
    }

    @Override
    public boolean deleteNotify(Integer jId) {
        int i = notifyMapper.deleteNotify(jId);
        return i == 1 ? true : false;
    }
}
