package com.example.food.service.imp;


import com.example.food.entity.Formu;
import com.example.food.mapper.ForumMapper;
import com.example.food.service.FormuService;
import com.example.food.utils.DateUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ForumRepo implements FormuService {

    @Resource
    private ForumMapper forumMapper;


    @Override
    public int publish(long id,String content, String userName, String userAvatar) {
        return forumMapper.publish(id,content,userName,userAvatar, DateUtils.getCurrentStringDate());
    }

    @Override
    public List<Formu> searchAll() {
        return forumMapper.searchAll();
    }

    @Override
    public int updateStar(Integer star, long Id) {
        return forumMapper.updateStar(star,Id);
    }

    @Override
    public int getStarById(long Id) {
        return forumMapper.searchStar(Id);
    }
}
