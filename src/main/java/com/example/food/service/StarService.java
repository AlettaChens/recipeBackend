package com.example.food.service;

import com.example.food.entity.Star;



public interface StarService {

    int publish(long forumId, long userId);

    Star search(long forumId, long userId);

    int delete( long forumId, long userId);
}
