package com.example.food.mapper;


import com.example.food.entity.Comment;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CommentMapper extends tk.mybatis.mapper.common.Mapper<Comment> {
    @Insert("insert into t_comment(id,forumId,content,date,comment_user)values(#{id},#{forumId},#{content},#{date},#{comment_user})")
    int publish(@Param(value = "id") long id, @Param(value = "forumId") long forumId, @Param(value = "content") String content, @Param(value = "date") String date, @Param(value = "comment_user") String comment_user);

    @Select("select * from t_comment where forumId=#{forumId}")
    List<Comment> searchAll(@Param(value = "forumId") long forumId);
}
