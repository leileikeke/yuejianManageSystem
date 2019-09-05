package com.leike.service;

import com.leike.pojo.Recommend;

import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-15 1:36
 */
public interface RecommendService {

    List<Recommend> selectRecommendList();

    boolean updateState(Integer jId, Boolean state, Integer cId, Integer id);

    Integer selectRecommendCount();
}
