package com.example.food.mapper;


import com.example.food.entity.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface VideoMapper extends Mapper<Video> {
    @Insert("insert into t_video(id,title,videoURL,date,active)values(#{id},#{title},#{videoURL},#{date},#{active})")
    int publish(@Param(value = "id") long id, @Param(value = "title") String title, @Param(value = "videoURL") String videoURL, @Param(value = "date") String date, @Param(value = "active") String active);

    @Select("select * from t_video where active=#{active}")
    List<Video> searchAll(@Param(value = "active") String active);

    @Update("update t_video set active=#{statue}where id=#{id}")
    int updateStatue(@Param(value = "statue") String statue, @Param(value = "id") long id);
}
