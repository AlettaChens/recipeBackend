package com.example.food.mapper;


import com.example.food.entity.Ingredient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface IngredientMapper extends tk.mybatis.mapper.common.Mapper<Ingredient> {
    @Insert("insert into t_ingredients(id,recipeId,ingredient)values(#{id},#{recipeId},#{ingredient})")
    int publish(@Param(value = "id") long id, @Param(value = "recipeId") long recipeId, @Param(value = "ingredient") String ingredient);

    @Select("select * from t_ingredients where recipeId=#{recipeId}")
    List<Ingredient> searchAll(@Param(value = "recipeId") long recipeId);
}
