package com.leike.service.impl;

import com.leike.mapper.RecommendMapper;
import com.leike.pojo.Coach;
import com.leike.pojo.Recommend;
import com.leike.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-15 1:37
 */
@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendMapper recommendMapper;

    @Override
    public List<Recommend> selectRecommendList() {
        List<Recommend> recommends = recommendMapper.selectRecommendList();
        return recommends;
    }

    @Override
    public boolean updateState(Integer jId) {
        int i = recommendMapper.deleteRecommend(jId);

        if (i == 1){
            int i1 = recommendMapper.updateCoachState(jId);
            if (i1 == 1){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer selectRecommendCount() {
        int i = recommendMapper.selectRecommendCount();
        return i;
    }
}
