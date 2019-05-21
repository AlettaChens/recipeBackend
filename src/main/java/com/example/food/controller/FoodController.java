package com.example.food.controller;


import com.example.food.entity.Food;
import com.example.food.entity.Ingredient;
import com.example.food.entity.Recipe;
import com.example.food.service.FoodService;
import com.example.food.service.IngredientService;
import com.example.food.utils.FileUploadUtils;
import com.example.food.utils.ResultMap;
import com.example.food.utils.UUIDutils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("food")
@Api(value = "菜谱接口", description = "菜谱接口")
public class FoodController {

    @Resource
    private FoodService foodService;

    @Resource
    private IngredientService ingredientService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "菜谱发布接口", notes = "菜谱发布接口")
    public ResultMap publish(String foodName, @RequestParam("file") MultipartFile file, String foodType, HttpServletRequest request, @RequestParam(value = "ingredients") List<String> ingredients) throws Exception {
        long recipeId = UUIDutils.getLongUUID();
        if (foodService.publish(recipeId, foodName, FileUploadUtils.upLoadPicture(file, "file/foodPicture", request), foodType) == 1) {
            if (ingredients != null) {
                for (String ingredient : ingredients) {
                    long ingredientId = UUIDutils.getLongUUID();
                    ingredientService.publish(ingredientId, recipeId, ingredient);
                }
            }
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }


    @RequestMapping(value = "searchAllByType", method = RequestMethod.POST)
    @ApiOperation(value = "获取某类型的所有菜谱", notes = "获取某类型的所有菜谱")
    public ResultMap searchAllByType(String type) {
        List<Food> foodList = foodService.searchAllByType(type);
        List<Recipe> recipeList = new ArrayList<>();
        if (foodList != null) {
            for (Food food : foodList) {
                List<Ingredient> ingredients = ingredientService.searchAll(food.getId());
                recipeList.add(new Recipe(food, ingredients));
            }
            return ResultMap.ok(recipeList);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "updateState", method = RequestMethod.POST)
    @ApiOperation(value = "更新菜谱状态", notes = "更新菜谱状态")
    public ResultMap updateState(String state, long id) {
        if (foodService.updateStatue(state, id) != 0) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "searchByName", method = RequestMethod.POST)
    @ApiOperation(value = "搜索菜谱", notes = "搜索菜谱")
    public ResultMap searchByName(String name) {
        List<Food> nameFoodList = foodService.searchByName(name);
        List<Recipe> recipeList = new ArrayList<>();
        if (nameFoodList != null) {
            for (int i=0;i<nameFoodList.size();i++) {
                List<Ingredient> ingredients = ingredientService.searchAll(nameFoodList.get(i).getId());
                recipeList.add(new Recipe(nameFoodList.get(i), ingredients));
            }
            return ResultMap.ok(recipeList);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "searchByStatue", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有菜谱", notes = "获取所有菜谱")
    public ResultMap searchByStatue(String statue) {
        List<Food> nameFoodList = foodService.searchByStatue(statue);
        List<Recipe> recipeList = new ArrayList<>();
        if (nameFoodList != null) {
            for (int i=0;i<nameFoodList.size();i++) {
                List<Ingredient> ingredients = ingredientService.searchAll(nameFoodList.get(i).getId());
                recipeList.add(new Recipe(nameFoodList.get(i), ingredients));
            }
            return ResultMap.ok(recipeList);
        }
        return ResultMap.fail(null);
    }
}
