package com.example.food.service.imp;



import com.example.food.mapper.HistoryMapper;
import com.example.food.service.HistoryService;
import com.example.food.utils.DateUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class HistoryRepo implements HistoryService {

    @Resource
    private HistoryMapper historyMapper;

    @Override
    public int publish(long Id,long recipeId, long userId) {
        return historyMapper.publish(Id,recipeId,userId, DateUtils.getCurrentStringDate(),1);
    }
}
