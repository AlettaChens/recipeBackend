package com.example.food.service;



import com.example.food.entity.Food;

import java.util.List;


public interface UserCFRecommendService {

    List<Long> recommend(long userId);

    List<Food> recommendRecipe(long id);
}
