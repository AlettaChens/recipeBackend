package com.example.food.service;


import com.example.food.entity.Food;


import java.util.List;

public interface FoodService {

    int publish(long UUID, String foodName, String foodURL, String foodType);

    List<Food> searchAllByType(String foodType);

    int updateStatue(String statue, long id);

    List<Food> searchByName(String foodName);

    List<Food> searchByStatue(String statue);
}
