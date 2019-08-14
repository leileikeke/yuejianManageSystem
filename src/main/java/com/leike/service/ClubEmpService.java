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

    List<Coach> selectEmpListToClub(Integer page, Integer limit, Integer id);

    List<Coach> selectEmpListToClubForTerm(Integer page, Integer limit, String jId, String name, String phone, String sex, Integer id);

    Integer selectEmpCountToClub(Integer id);

    boolean insertCoach(Coach coach,Integer id);

}
