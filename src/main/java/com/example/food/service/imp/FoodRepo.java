package com.example.food.service.imp;


import com.example.food.entity.Food;
import com.example.food.mapper.FoodMapper;
import com.example.food.service.FoodService;
import com.example.food.utils.DateUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class FoodRepo implements FoodService {

    @Resource
    private FoodMapper foodMapper;

    @Override
    public int publish(long id, String foodName, String foodURL, String foodType) {
        return foodMapper.publish(id, foodName, foodURL, foodType, DateUtils.getCurrentStringDate(), "待验证");
    }

    @Override
    public List<Food> searchAllByType(String foodType) {
        return foodMapper.searchAllByType(foodType, "验证通过");
    }

    @Override
    public int updateStatue(String statue, long id) {
        return foodMapper.updateStatue(statue, id);
    }

    @Override
    public List<Food> searchByName(String foodName) {
        return foodMapper.searchByName(foodName);
    }

    @Override
    public List<Food> searchByStatue(String statue) {
        return foodMapper.searchByStatue(statue);
    }
}
