package com.leike.service;

import com.leike.pojo.Club;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-09 21:53
 */
public interface ClubService {

    Integer selectClubCount();

    List<Club> selectClubList(Integer page, Integer limit);

    List<Club> selectClubListForTerm(Integer page, Integer limit, String cId, String name, String phone);

    boolean deleteClub(Integer cId, String pic, String uploadPath);

    boolean updateClub(Club club, String uploadPath);

    boolean queryClub(String name);

    boolean insertClub(Club club);

}
