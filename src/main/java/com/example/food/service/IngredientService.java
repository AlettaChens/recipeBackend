package com.example.food.service;



import com.example.food.entity.Ingredient;

import java.util.List;

public interface IngredientService {

    int publish(long id, long recipeId, String ingredient);

    List<Ingredient> searchAll(long recipeId);
}
