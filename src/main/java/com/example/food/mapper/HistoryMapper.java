package com.example.food.mapper;

import com.example.food.entity.History;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface HistoryMapper extends tk.mybatis.mapper.common.Mapper<History> {
    @Insert("insert into t_history(id,recipeId,userId,readTime,preference)values(#{id},#{recipeId},#{userId},#{readTime},#{preference})")
    int publish(@Param(value = "id") long id, @Param(value = "recipeId") long recipeId, @Param(value = "userId") long userId, @Param(value = "readTime") String readTime, @Param(value = "preference") float preference);
}
