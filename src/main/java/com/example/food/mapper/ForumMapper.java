package com.example.food.mapper;


import com.example.food.entity.Formu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface ForumMapper extends tk.mybatis.mapper.common.Mapper<Formu> {

    @Insert("insert into t_formu(id,content,userName,userAvatar,date)values(#{id},#{content},#{userName},#{userAvatar},#{date})")
    int publish(@Param(value = "id") long id, @Param(value = "content") String content, @Param(value = "userName") String userName, @Param(value = "userAvatar") String userAvatar, @Param(value = "date") String date);

    @Select("select * from t_formu")
    List<Formu> searchAll();

    @Select("select star from t_formu where id=#{id}")
    int searchStar(@Param(value = "id") long id);

    @Update("update t_formu set star=#{star} where id=#{id}")
    int updateStar(@Param(value = "star") long star, @Param(value = "id") long id);
}