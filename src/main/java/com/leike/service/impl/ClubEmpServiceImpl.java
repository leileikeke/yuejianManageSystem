package com.leike.service.impl;

import com.leike.mapper.ClubEmpMapper;
import com.leike.pojo.Coach;
import com.leike.service.ClubEmpService;
import com.leike.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-13 14:46
 */
@Service("clubEmpService")
public class ClubEmpServiceImpl implements ClubEmpService {

    @Autowired
    private ClubEmpMapper clubEmpMapper;

    @Override
    public List<Coach> selectEmpListForTerm(Integer page, Integer limit, String jId, String name, String phone, String sex) {
        List<Coach> coaches = clubEmpMapper.selectEmpListForTerm(page, limit, jId, name, phone, sex);
        return coaches;
    }

    @Override
    public List<Coach> selectEmpList(Integer page, Integer limit) {
        List<Coach> coaches = clubEmpMapper.selectEmpList(page, limit);
        return coaches;
    }

    @Override
    public Integer selectEmpCount() {
        Integer i = clubEmpMapper.selectEmpCount();
        return i;
    }

    @Override
    public boolean updateState(Integer jId, Boolean state) {
        int i = clubEmpMapper.updateState(jId, state);
        return i == 1 ? true : false;
    }

    @Override
    public boolean updateCoach(Coach coach, String uploadPath) {
        //获取用户原头像
        String pic = clubEmpMapper.selectCoachForPic(coach.getjId());
        //如果修改了用户头像则删除原头像
        if (!coach.getPic().equals(pic)) {
            FileUtil.deleteFile(uploadPath, pic);
        }

        int i = clubEmpMapper.updateCoach(coach);
        return i == 1 ? true : false;
    }

    @Override
    public boolean deleteCoach(Integer jId, String pic, String uploadPath) {
        //删除服务器上的用户头像
        FileUtil.deleteFile(uploadPath, pic);

        int i = clubEmpMapper.deleteCoach(jId);
        return i == 1 ? true : false;
    }

    @Override
    public boolean queryCoach(String name) {
        int i = clubEmpMapper.queryCoach(name);
        return i == 1 ? false : true;
    }

    @Override
    public boolean insertCoach(Coach coach) {
        int i = clubEmpMapper.insertCoach(coach);
        return i == 1 ? true : false;
    }
}
