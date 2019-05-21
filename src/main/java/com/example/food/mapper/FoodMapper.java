package com.example.food.mapper;


import com.example.food.entity.Food;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FoodMapper extends tk.mybatis.mapper.common.Mapper<Food> {
    @Insert("insert into t_food(id,foodName,foodURL,foodType,date,active)values(#{id},#{foodName},#{foodURL},#{foodType},#{date},#{active})")
    int publish(@Param(value = "id") long id, @Param(value = "foodName") String foodName, @Param(value = "foodURL") String foodURL, @Param(value = "foodType") String foodType, @Param(value = "date") String date, @Param(value = "active") String active);

    @Select("select * from t_food where foodType=#{foodType} and active=#{statue}")
    List<Food> searchAllByType(@Param(value = "foodType") String foodType, @Param(value = "statue") String statue);

    @Select("select * from t_food where active=#{statue}")
    List<Food> searchByStatue(@Param(value = "statue") String statue);

    @Select("select * from t_food where foodName like '%${foodName}%'")
    List<Food> searchByName(@Param(value = "foodName") String foodName);

    @Select("select * from t_food where id=#{id}")
    Food searchById(@Param(value = "id") long id);

    @Update("update t_food set active=#{statue}where id=#{id}")
    int updateStatue(@Param(value = "statue") String statue, @Param(value = "id") long id);
}
