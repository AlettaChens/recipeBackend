package com.example.food.service.imp;

import com.example.food.entity.Star;
import com.example.food.mapper.StarMapper;
import com.example.food.service.StarService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StarRepo implements StarService {

    @Resource
    private StarMapper starMapper;

    @Override
    public int publish( long forumId, long userId) {
        return starMapper.publishStar(forumId, userId);
    }

    @Override
    public Star search(long forumId, long userId) {
        return starMapper.searchStar(forumId, userId);
    }

    @Override
    public int delete(long forumId, long userId) {
        return starMapper.deleteStar(forumId, userId);
    }
}
