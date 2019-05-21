package com.example.food.service;


import com.example.food.entity.User;

public interface UserService {

    int register(long userId, String nickname, String password, String userType);

    User login(String nickname, String password, String userType);

    int updateURL(String imageURL, long userId);
}
