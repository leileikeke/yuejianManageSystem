package com.leike.service;

import com.leike.pojo.Coach;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-13 14:46
 */
public interface ClubEmpService {


    List<Coach> selectEmpListForTerm(Integer page, Integer limit, String jId, String name, String phone, String sex);

    List<Coach> selectEmpList(Integer page, Integer limit);

    Integer selectEmpCount();

    boolean updateState(Integer jId, Boolean state);

    boolean updateCoach(Coach coach, String uploadPath);

    boolean deleteCoach(Integer jId, String pic, String uploadPath);

    boolean queryCoach(String name);

    boolean insertCoach(Coach coach);
}
