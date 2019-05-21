package com.example.food.service.imp;


import com.example.food.entity.Comment;
import com.example.food.mapper.CommentMapper;
import com.example.food.service.CommentService;
import com.example.food.utils.DateUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class CommentRepo implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public int publish(long id,long forumId, String content, String comment_user) {
        return commentMapper.publish(id,forumId,content, DateUtils.getCurrentStringDate(),comment_user);
    }

    @Override
    public List<Comment> searchAll(long forumId) {
        return commentMapper.searchAll(forumId);
    }
}
