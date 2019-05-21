package com.example.food.service;



import com.example.food.entity.Comment;

import java.util.List;

public interface CommentService {
    int publish(long id, long forumId, String content, String comment_user);

    List<Comment> searchAll(long forumId);
}

