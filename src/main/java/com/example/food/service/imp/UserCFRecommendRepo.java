package com.example.food.service.imp;


import com.example.food.entity.Food;
import com.example.food.mapper.FoodMapper;
import com.example.food.service.UserCFRecommendService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLBooleanPrefJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class UserCFRecommendRepo implements UserCFRecommendService {

    @Value("${com.kadoufall.mahout.table-name}")
    private String tableName;

    @Value("${com.kadoufall.mahout.user-column}")
    private String userColumn;

    @Value("${com.kadoufall.mahout.item-column}")
    private String itemColumn;

    @Value("${com.kadoufall.mahout.pref-column}")
    private String prefColumn;

    @Value("${com.kadoufall.mahout.recommendNum}")
    private int recommendNum;

    @Autowired
    DataSource dataSource;

    @Resource
    FoodMapper foodMapper;

    private DataModel dataModel = null;
    private Recommender recommender = null;

    public void init() {
        try {
           dataModel = new MySQLBooleanPrefJDBCDataModel(dataSource, tableName, userColumn, itemColumn, prefColumn);
            UserSimilarity similarity = new LogLikelihoodSimilarity(dataModel);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, similarity, dataModel);
            recommender = new GenericBooleanPrefUserBasedRecommender(dataModel, neighborhood, similarity);
        } catch (Exception e) {
          System.out.print(e.toString());
        }
    }

    @Override
    public List<Long> recommend(long id) {
        init();
        List<Long> ret = new ArrayList<>();
        try {
            List<RecommendedItem> recommendedItems = recommender.recommend(id, this.recommendNum);
            Set<Long> foodIds = new HashSet<>();
            for (RecommendedItem item : recommendedItems) {
                foodIds.add(item.getItemID());
            }
            ret.addAll(foodIds);
        } catch (TasteException e) {
            System.out.print(e.toString());
        }
        return ret;
    }

    @Override
    public List<Food> recommendRecipe(long id) {
        return this.recommend(id)
                .parallelStream()
                .map(foodId -> foodMapper.searchById(foodId))
                .collect(Collectors.toList());
    }
}
