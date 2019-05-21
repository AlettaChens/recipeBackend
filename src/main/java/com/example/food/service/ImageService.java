package com.example.food.service;




import com.example.food.entity.Image;

import java.util.List;

public interface ImageService {

    int publish(long id, long forumId, String pictureURL);

    List<Image> searchAll(long forumId);
}
