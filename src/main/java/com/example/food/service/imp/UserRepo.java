
package com.example.food.service.imp;



import com.example.food.entity.User;
import com.example.food.mapper.UserMapper;
import com.example.food.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class UserRepo implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int register(long userId,String nickname, String password, String userType) {
        return userMapper.register(userId,nickname,password,userType);
    }

    @Override
    public User login(String nickname, String password, String userType) {
        return userMapper.login(nickname,password,userType);
    }

    @Override
    public int updateURL(String imageURL, long userId) {
        return userMapper.updateURL(imageURL,userId);
    }
}

