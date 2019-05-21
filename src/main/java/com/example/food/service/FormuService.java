package com.example.food.service;



import com.example.food.entity.Formu;

import java.util.List;

public interface FormuService {

    int publish(long UUID, String content, String userName, String userAvatar);

    List<Formu> searchAll();

    int updateStar(Integer star, long Id);

    int getStarById(long Id);
}
