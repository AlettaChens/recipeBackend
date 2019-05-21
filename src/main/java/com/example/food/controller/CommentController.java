package com.example.food.controller;


import com.example.food.service.CommentService;
import com.example.food.utils.ResultMap;
import com.example.food.utils.UUIDutils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("comment")
@Api(value = "评论接口", description = "评论接口")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "评论发布接口", notes = "评论发布接口")
    public ResultMap publish(long forumId, String content, String comment_user) {
        long UUID= UUIDutils.getLongUUID();
        if (commentService.publish(UUID,forumId, content, comment_user) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }


    @RequestMapping(value = "searchAll", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有评论条目", notes = "获取所有评论条目")
    public ResultMap searchAll(long forumId) {
        if (commentService.searchAll(forumId) != null) {
            return ResultMap.ok(commentService.searchAll(forumId));
        }
        return ResultMap.fail(null);
    }
}
