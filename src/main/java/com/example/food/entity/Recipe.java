package com.example.food.entity;

import java.util.List;

public class Recipe {
    private Food food;
    private List<Ingredient> ingredients;

    public Recipe(Food food, List<Ingredient> ingredients) {
        this.food = food;
        this.ingredients = ingredients;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
