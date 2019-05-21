package com.example.food.mapper;


import com.example.food.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    @Insert("insert into t_user(userId,nickname,password,userType)values(#{userId},#{nickname},#{password},#{userType})")
    int register(@Param(value = "userId") long userId, @Param(value = "nickname") String nickname, @Param(value = "password") String password, @Param(value = "userType") String userType);

    @Select("select * from t_user where nickname=#{nickname}and password=#{password}and userType=#{userType}")
    User login(@Param(value = "nickname") String nickname, @Param(value = "password") String password, @Param(value = "userType") String userType);

    @Update("update t_user set avatarURL=#{imageURL}where userId=#{userId}")
    int updateURL(@Param(value = "imageURL") String imageURL, @Param(value = "userId") long userId);

}