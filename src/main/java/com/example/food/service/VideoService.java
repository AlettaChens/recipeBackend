package com.example.food.service;

import com.example.food.entity.Video;


import java.util.List;

public interface VideoService {

    int publish(long id, String title, String videoURL);


    List<Video> searchAll(String active);

    int updateStatue(String statue, long id);
}
