package com.example.food.mapper;


import com.example.food.entity.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface ImageMapper extends tk.mybatis.mapper.common.Mapper<Image> {
    @Insert("insert into t_picture(id,forumId,pictureURL)values(#{id},#{forumId},#{pictureURL})")
    int publish(@Param(value = "id") long id, @Param(value = "forumId") long forumId, @Param(value = "pictureURL") String pictureURL);

    @Select("select * from t_picture where forumId=#{forumId}")
    List<Image> searchAll(@Param(value = "forumId") long forumId);
}
