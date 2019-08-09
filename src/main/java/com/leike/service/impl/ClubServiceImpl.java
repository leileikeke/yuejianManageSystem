package com.leike.service.impl;

import com.leike.mapper.ClubMapper;
import com.leike.pojo.Club;
import com.leike.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-09 21:54
 */
@Service("clubService")
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubMapper clubMapper;

    @Override
    public Integer selectClubCount() {
        int i = clubMapper.selectClubCount();
        return i;
    }

    @Override
    public List<Club> selectClubList(Integer page, Integer limit) {
        List<Club> clubs = clubMapper.selectClubList(page, limit);
        return clubs;
    }

    @Override
    public List<Club> selectClubListForTerm(Integer page, Integer limit, String cId, String name, String phone) {
        List<Club> clubs = clubMapper.selectClubListForTerm(page, limit, cId, name, phone);
        return clubs;
    }
}
