package com.example.food.mapper;


import com.example.food.entity.Star;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
@org.apache.ibatis.annotations.Mapper
public interface StarMapper extends Mapper<Star> {
    @Insert("insert into t_star(forumId,userId)values(#{forumId},#{userId})")
    int publishStar(@Param(value = "forumId") long forumId, @Param(value = "userId") long userId);

    @Select("select * from t_star where forumId=#{forumId} and userId=#{userId}")
    Star searchStar(@Param(value = "forumId") long forumId, @Param(value = "userId") long userId);

    @Delete("delete from t_star where forumId=#{forumId} and userId=#{userId}")
    int deleteStar(@Param(value = "forumId") long forumId, @Param(value = "userId") long userId);
}
