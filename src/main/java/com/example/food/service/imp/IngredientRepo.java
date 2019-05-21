package com.example.food.service.imp;


import com.example.food.entity.Ingredient;
import com.example.food.mapper.IngredientMapper;
import com.example.food.service.IngredientService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class IngredientRepo implements IngredientService {
    @Resource
    private IngredientMapper ingredientMapper;
    @Override
    public int publish( long id,long recipeId, String ingredient) {
        return ingredientMapper.publish(id,recipeId,ingredient);
    }

    @Override
    public List<Ingredient> searchAll(long recipeId) {
        return ingredientMapper.searchAll(recipeId);
    }
}
