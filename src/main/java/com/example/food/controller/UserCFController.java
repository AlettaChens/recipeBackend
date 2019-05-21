package com.example.food.controller;


import com.example.food.entity.Food;
import com.example.food.entity.Ingredient;
import com.example.food.entity.Recipe;
import com.example.food.service.IngredientService;
import com.example.food.service.UserCFRecommendService;
import com.example.food.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("recommend")
@Api(value = "算法推荐接口", description = "算法推荐接口")
public class UserCFController {

    @Resource
    private UserCFRecommendService userCFRecommendService;

    @Resource
    private IngredientService ingredientService;

    @RequestMapping(value = "push", method = RequestMethod.POST)
    @ApiOperation(value = "基于用户的协同过滤算法", notes = "基于用户的协同过滤算法")
    public ResultMap publish(long userId) {
        List<Food> foodList = userCFRecommendService.recommendRecipe(userId);
        List<Recipe> recipeList = new ArrayList<>();
        if (foodList != null) {
            for (int j = 0; j < foodList.size(); j++) {
                List<Ingredient> ingredients = ingredientService.searchAll(foodList.get(j).getId());
                recipeList.add(new Recipe(foodList.get(j), ingredients));
            }
            return ResultMap.ok(recipeList);
        }
        return ResultMap.fail(null);
    }
}
